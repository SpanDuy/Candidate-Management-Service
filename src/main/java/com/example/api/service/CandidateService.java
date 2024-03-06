package com.example.api.service;

import com.example.api.domain.Candidate;
import com.example.api.dto.CandidateDto;

import java.util.List;

public interface CandidateService {
    List<CandidateDto> getCandidates();
    void createCandidate(CandidateDto candidate);
    void updateCandidate(Long id, CandidateDto candidate);
}
