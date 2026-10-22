package com.example.repository;

import com.example.models.Budget;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long>
{
    Budget findByUserId(String userdid);
}
