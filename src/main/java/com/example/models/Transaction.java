package com.example.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


    @Entity
    @Data
    @RequiredArgsConstructor
    public class Transaction
    {
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String userid;

        private BigDecimal Amount;

        private String Recipient;

        private LocalDateTime timestamp;

        @ManyToOne
        @JoinColumn(name = "subcategory_id")
        private SubCategory subcategory;

    }
