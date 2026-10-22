package com.example.services;

import com.example.Events.ThresholdBreachEvent;
import com.example.models.Budget;
import com.example.models.Transaction;
import com.example.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public Budget findBudgetByUserId(String userid) {
        return budgetRepository.findByUserId(userid);
    }

    public Budget updateBudgetByUserId(Transaction transaction) {
        String userid = transaction.getUserid();
        Budget budget = budgetRepository.findByUserId(userid);

        // Used .add() instead of the + operator
        budget.setCurrentTotalSpent(budget.getCurrentTotalSpent().add(transaction.getAmount()));

        // budgetRepository.save(budget); //
        return budget;
    }

    @RabbitListener(queues = "transaction_queue")
    public void processTransaction(Transaction transaction) {
        Budget updatedBudget = updateBudgetByUserId(transaction);

        boolean alertNeeded = isThresholdBreached(updatedBudget.getCurrentTotalSpent(), updatedBudget.getMonthlyBudget());

        if (alertNeeded) {
            applicationEventPublisher.publishEvent(new ThresholdBreachEvent(updatedBudget.getUserid()));
        }
    }

    private boolean isThresholdBreached(BigDecimal currentTotalSpent, BigDecimal monthlyBudget) {
        BigDecimal currentDay = BigDecimal.valueOf(LocalDate.now().getDayOfMonth());
        BigDecimal daysInMonth = BigDecimal.valueOf(YearMonth.now().lengthOfMonth());

        // 1. Calculate daily allowance
        // Note: You must specify a scale and RoundingMode when dividing BigDecimals
        // to avoid ArithmeticExceptions on repeating decimals (like 100 / 3).
        BigDecimal dailyAllowance = monthlyBudget.divide(daysInMonth, 2, RoundingMode.HALF_UP);

        // 2. Calculate expected spent
        BigDecimal expectedSpent = dailyAllowance.multiply(currentDay);

        // 3. Calculate allowed threshold (20% buffer)
        BigDecimal twentyPercent = new BigDecimal("0.20");
        BigDecimal allowedThreshold = expectedSpent.multiply(twentyPercent);

        // 4. Compare current spent to the threshold
        // compareTo() returns 1 if greater, 0 if equal, and -1 if less.
        return currentTotalSpent.compareTo(allowedThreshold) > 0;
    }
}