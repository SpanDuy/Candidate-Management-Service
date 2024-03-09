package com.example.api.repository;

import com.example.api.domain.CandidateTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateTestRepository extends JpaRepository<CandidateTest, Long>, JpaSpecificationExecutor<CandidateTest> {
}
