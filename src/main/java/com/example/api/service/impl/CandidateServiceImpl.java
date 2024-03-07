package com.example.api.service.impl;

import com.example.api.domain.Candidate;
import com.example.api.domain.CandidateTest;
import com.example.api.domain.Direction;
import com.example.api.dto.candidateDto.CandidateCreateDto;
import com.example.api.dto.candidateDto.CandidateListDto;
import com.example.api.dto.candidateDto.CandidateUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.repository.CandidateRepository;
import com.example.api.repository.DirectionRepository;
import com.example.api.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final DirectionRepository directionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CandidateListDto> getCandidates() {
        return candidateRepository.findAll().stream()
                .map(candidate -> modelMapper.map(candidate, CandidateListDto.class))
                .toList();
    }

    @Override
    public void createCandidate(CandidateCreateDto candidateDto) {
        List<Direction> directions = directionRepository.findAllById(candidateDto.getPossibleDirections());
        Candidate candidate = modelMapper.map(candidateDto, Candidate.class);
        candidate.setPossibleDirections(directions);

        candidateRepository.save(candidate);
    }

    @Override
    public void updateCandidate(Long id, CandidateUpdateDto candidateDto) throws NotFoundException {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Candidate", "Entity with id = " + id + "Not found"));

        List<Direction> directions = directionRepository.findAllById(candidateDto.getPossibleDirections());
        candidate.setNotNullFields(modelMapper.map(candidateDto, Candidate.class));
        candidate.setPossibleDirections(directions);

        candidateRepository.save(modelMapper.map(candidate, Candidate.class));
    }
}
