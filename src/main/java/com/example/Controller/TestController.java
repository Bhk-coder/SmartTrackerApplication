package com.example.Controller;

import com.example.models.Budget;
import com.example.models.Transaction;
import com.example.repository.BudgetRepository;
import com.example.services.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController
{
   private final BudgetService budgetService;

    @PostMapping("/check")
  public void  testApi(@RequestBody Transaction transaction)
  {
     budgetService.processTransaction(transaction);
  }

}
