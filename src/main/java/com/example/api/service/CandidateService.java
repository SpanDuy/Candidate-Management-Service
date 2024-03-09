package com.example.api.service;

import com.example.api.dto.candidateDto.CandidateCreateDto;
import com.example.api.dto.candidateDto.CandidateListDto;
import com.example.api.dto.candidateDto.CandidateSearchCriteria;
import com.example.api.dto.candidateDto.CandidateUpdateDto;
import com.example.api.exception.NotFoundException;
import org.springframework.data.domain.Page;

public interface CandidateService {
    Page<CandidateListDto> getCandidates(Integer page, Integer pageSize, CandidateSearchCriteria candidateSearchCriteria);
    void createCandidate(CandidateCreateDto candidate);
    void updateCandidate(Long id, CandidateUpdateDto candidate) throws NotFoundException;
}
