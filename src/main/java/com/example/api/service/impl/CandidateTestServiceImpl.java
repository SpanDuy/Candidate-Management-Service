package com.example.api.service.impl;

import com.example.api.domain.*;
import com.example.api.dto.candidateTestDto.CandidateTestCreateDto;
import com.example.api.dto.candidateTestDto.CandidateTestListDto;
import com.example.api.dto.candidateTestDto.CandidateTestUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.repository.CandidateRepository;
import com.example.api.repository.CandidateTestRepository;
import com.example.api.repository.TestRepository;
import com.example.api.repository.TestResultRepository;
import com.example.api.service.CandidateTestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CandidateTestServiceImpl implements CandidateTestService {

    private final CandidateTestRepository candidateTestRepository;
    private final CandidateRepository candidateRepository;
    private final TestRepository testRepository;
    private final TestResultRepository testResultRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CandidateTestListDto> getCandidateTests() {
        return candidateTestRepository.findAll().stream()
                .map(candidateTest -> modelMapper.map(candidateTest, CandidateTestListDto.class))
                .toList();
    }

    @Override
    public void createCandidateTest(CandidateTestCreateDto candidateTestDto) throws NotFoundException {
        Candidate candidate = candidateRepository.findById(candidateTestDto.getCandidate())
                .orElseThrow(() -> new NotFoundException("Candidate", "Entity with id = " + candidateTestDto.getCandidate() + "Not found"));

        Test test = testRepository.findById(candidateTestDto.getTest())
                .orElseThrow(() -> new NotFoundException("Test", "Entity with id = " + candidateTestDto.getTest() + "Not found"));

        CandidateTest candidateTest = modelMapper.map(candidateTestDto, CandidateTest.class);

        candidateTest.setCandidate(candidate);
        candidateTest.setTest(test);

        List<TestResult> testResults = candidateTestDto.getTestResults().stream()
                .map(testResultDto -> modelMapper.map(testResultDto, TestResult.class))
                .toList();

        candidateTestRepository.save(candidateTest);
    }

    @Override
    public void updateCandidateTest(Long id, CandidateTestUpdateDto candidateTestDto) throws NotFoundException {
        Candidate candidate = candidateRepository.findById(candidateTestDto.getCandidate())
                .orElseThrow(() -> new NotFoundException("Candidate", "Entity with id = " + candidateTestDto.getCandidate() + "Not found"));

        Test test = testRepository.findById(candidateTestDto.getTest())
                .orElseThrow(() -> new NotFoundException("Test", "Entity with id = " + candidateTestDto.getTest() + "Not found"));

        CandidateTest candidateTest = candidateTestRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Candidate", "Entity Test with id = " + id + "Not found"));

        candidateTest.setCandidate(candidate);
        candidateTest.setTest(test);

        List<TestResult> testResults = candidateTestDto.getTestResults().stream()
                .map(testResultDto -> modelMapper.map(testResultDto, TestResult.class))
                .toList();

        candidateTestRepository.save(candidateTest);
    }
}
