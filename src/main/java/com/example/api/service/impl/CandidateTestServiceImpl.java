package com.example.api.service.impl;

import com.example.api.domain.CandidateTest;
import com.example.api.dto.CandidateTestDto;
import com.example.api.repository.CandidateTestRepository;
import com.example.api.service.CandidateTestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CandidateTestServiceImpl implements CandidateTestService {

    private final CandidateTestRepository candidateTestRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CandidateTestDto> getCandidateTests() {
        return candidateTestRepository.findAll().stream()
                .map(candidateTest -> modelMapper.map(candidateTest, CandidateTestDto.class))
                .toList();
    }

    @Override
    public void createCandidateTest(CandidateTestDto candidateTest) {
        candidateTestRepository.save(modelMapper.map(candidateTest, CandidateTest.class));
    }

    @Override
    public void updateCandidateTest(Long id, CandidateTestDto candidateTest) {
        candidateTestRepository.save(modelMapper.map(candidateTest, CandidateTest.class));
    }
}
