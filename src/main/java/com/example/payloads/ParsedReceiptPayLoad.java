package com.example.payloads;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ParsedReceiptPayLoad
{
   private String merchant;

   private List<String> items;

   private BigDecimal amount;

   private  LocalDateTime timeStamp;

   private String category;

   private String subcategory;
}
