package com.example.repository;

import com.example.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long>
    {
        @Query("""
    SELECT t.subcategory.category.name, SUM(t.Amount) 
    FROM Transaction t 
    WHERE t.userid = :userId 
    GROUP BY t.subcategory.category.name
    """)
        List<Object[]> findTotalSpentByCategory(@Param("userId") String userId);
    }
