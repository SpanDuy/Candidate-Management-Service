package com.example.api.service;

import com.example.api.dto.testResultDto.TestResultDto;

import java.util.List;

public interface TestResultService {
    List<TestResultDto> getTestResults();
    void createTestResult(TestResultDto testResult);
    void updateTestResult(Long id, TestResultDto testResult);
}
