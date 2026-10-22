package com.example.services;

import com.example.dto.CategoryAnalyticsDTO;
import com.example.repository.TransactionRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticsService
{
   private final TransactionRepository transactionRepository;


  // public List<CategoryAnalyticsDTO> getCategorySpendingBreakdown(String userid)
  // {
    //   List<Object[]> results = transactionRepository.findTotalSpentByCategory(userid);


  // }
}
