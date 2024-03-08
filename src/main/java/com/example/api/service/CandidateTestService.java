package com.example.api.service;

import com.example.api.domain.CandidateTest;
import com.example.api.dto.candidateDto.CandidateUpdateDto;
import com.example.api.dto.candidateTestDto.CandidateTestCreateDto;
import com.example.api.dto.candidateTestDto.CandidateTestListDto;
import com.example.api.dto.candidateTestDto.CandidateTestSearchCriteria;
import com.example.api.dto.candidateTestDto.CandidateTestUpdateDto;
import com.example.api.exception.NotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CandidateTestService {
    Page<CandidateTestListDto> getCandidateTests(Integer page, Integer pageSize,
                                                 CandidateTestSearchCriteria candidateTestSearchCriteria);
    void createCandidateTest(CandidateTestCreateDto candidateTest) throws NotFoundException;
    void updateCandidateTest(Long id, CandidateTestUpdateDto candidateTest) throws NotFoundException;
}
