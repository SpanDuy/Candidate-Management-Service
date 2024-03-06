package com.example.api.repository;

import com.example.api.domain.CandidateTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateTestRepository extends JpaRepository<CandidateTest, Long> {
}
