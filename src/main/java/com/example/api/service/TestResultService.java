package com.example.api.service;

import com.example.api.domain.Direction;
import com.example.api.domain.TestResult;
import com.example.api.dto.TestResultDto;

import java.util.List;

public interface TestResultService {
    List<TestResultDto> getTestResults();
    void createTestResult(TestResultDto testResult);
    void updateTestResult(Long id, TestResultDto testResult);
}
