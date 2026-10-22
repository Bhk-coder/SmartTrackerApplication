package com.example.repository;

import com.example.models.Commitment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommitmentRepository extends JpaRepository<Commitment, Long>
{
  List<Commitment> findByuserId(String userId);
}
