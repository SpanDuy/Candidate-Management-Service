package com.example.api.service;

import com.example.api.dto.testDto.TestCreateDto;
import com.example.api.dto.testDto.TestListDto;
import com.example.api.dto.testDto.TestUpdateDto;
import com.example.api.exception.NotFoundException;

import java.util.List;

public interface TestService {
    List<TestListDto> getTests();
    void createTest(TestCreateDto test);
    void updateTest(Long id, TestUpdateDto test) throws NotFoundException;
}
