package com.example.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

    @Entity
    @Data
    @RequiredArgsConstructor
    public class Budget
    {

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Long id;

      private String userid;

      private BigDecimal monthlyBudget;

      private BigDecimal  currentTotalSpent;

      private LocalDate cycleStartDate;




    }
