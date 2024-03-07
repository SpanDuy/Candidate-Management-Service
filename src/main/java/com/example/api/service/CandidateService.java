package com.example.api.service;

import com.example.api.dto.candidateDto.CandidateCreateDto;
import com.example.api.dto.candidateDto.CandidateListDto;
import com.example.api.dto.candidateDto.CandidateUpdateDto;
import com.example.api.exception.NotFoundException;

import java.util.List;

public interface CandidateService {
    List<CandidateListDto> getCandidates();
    void createCandidate(CandidateCreateDto candidate);
    void updateCandidate(Long id, CandidateUpdateDto candidate) throws NotFoundException;
}
