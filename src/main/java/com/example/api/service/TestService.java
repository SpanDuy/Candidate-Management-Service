package com.example.api.service;

import com.example.api.domain.Test;
import com.example.api.domain.TestResult;
import com.example.api.dto.TestDto;

import java.util.List;

public interface TestService {
    List<TestDto> getTests();
    void createTest(TestDto test);
    void updateTest(Long id, TestDto test);
}
