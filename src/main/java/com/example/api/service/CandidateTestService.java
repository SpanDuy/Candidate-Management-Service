package com.example.api.service;

import com.example.api.domain.Candidate;
import com.example.api.domain.CandidateTest;
import com.example.api.dto.CandidateTestDto;

import java.util.List;

public interface CandidateTestService {
    List<CandidateTestDto> getCandidateTests();
    void createCandidateTest(CandidateTestDto candidateTest);
    void updateCandidateTest(Long id, CandidateTestDto candidateTest);
}
