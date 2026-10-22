package com.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@RequiredArgsConstructor
public class BudgetStatusDTO
{
 private BigDecimal totalBudget;

 private BigDecimal remainingDiscretionaryPool;

 private String statusMessage;

 private boolean isSafe;
}
