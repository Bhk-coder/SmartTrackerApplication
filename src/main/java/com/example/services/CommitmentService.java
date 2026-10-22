/*
package com.example.services;

import com.example.dto.Commit;
import com.example.models.Commitment;
import com.example.repository.CommitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommitmentService {

    private final CommitmentRepository commitmentRepository;

    public List<Commitment> findCommitmentByUserId(String userId) {
        List<Commitment> commitments = commitmentRepository.findByuserId(userId);

        // Best Practice Note: Spring Data JPA typically returns an empty list rather than null.
        // It is safer to check for both null and emptiness.
        if (commitments == null || commitments.isEmpty()) {
            throw new RuntimeException("Commitment Does Not Exists");
        }
        return commitments;
    }

    public Commitment createCommitment(Commitment commitment) {
        Commitment newCommit = Commitment.builder()
                .amount(commitment.getAmount())
                .userId(commitment.getUserId())
                .description(commitment.getDescription())
                .timeStamp(commitment.getTimeStamp())
                .build();

        return commitmentRepository.save(newCommit);
    }

    public BigDecimal sumOfCommitments(String userId) {
        List<Commitment> commitments  = findCommitmentByUserId(userId);
        if (commitments == null || commitments.isEmpty()) {
            return BigDecimal.ZERO;
        }

        // Using Stream API with BigDecimal requires mapping and reducing
        return commitments.stream()
                .map(Commitment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // public Commitment updateCommitment(Commit commit, Long commitId) {
    //
    // }
}*/
