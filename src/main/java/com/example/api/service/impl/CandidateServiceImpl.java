package com.example.api.service.impl;

import com.example.api.domain.Candidate;
import com.example.api.dto.CandidateDto;
import com.example.api.repository.CandidateRepository;
import com.example.api.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CandidateDto> getCandidates() {
        return candidateRepository.findAll().stream()
                .map(candidate -> modelMapper.map(candidate, CandidateDto.class))
                .toList();
    }

    @Override
    public void createCandidate(CandidateDto candidate) {
        candidateRepository.save(modelMapper.map(candidate, Candidate.class));
    }

    @Override
    public void updateCandidate(Long id, CandidateDto candidate) {
        candidateRepository.save(modelMapper.map(candidate, Candidate.class));
    }
}
