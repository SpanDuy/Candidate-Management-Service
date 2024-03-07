package com.example.api.service.impl;

import com.example.api.domain.TestResult;
import com.example.api.dto.testResultDto.TestResultDto;
import com.example.api.repository.TestResultRepository;
import com.example.api.service.TestResultService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TestResultServiceImpl implements TestResultService {

    private final TestResultRepository testResultRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TestResultDto> getTestResults() {
        return testResultRepository.findAll().stream()
                .map(testResult -> modelMapper.map(testResult, TestResultDto.class))
                .toList();
    }

    @Override
    public void createTestResult(TestResultDto testResult) {
        testResultRepository.save(modelMapper.map(testResult, TestResult.class));
    }

    @Override
    public void updateTestResult(Long id, TestResultDto testResult) {
        testResultRepository.save(modelMapper.map(testResult, TestResult.class));
    }
}
