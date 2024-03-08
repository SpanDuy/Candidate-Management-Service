package com.example.api.service;

import com.example.api.dto.testDto.TestCreateDto;
import com.example.api.dto.testDto.TestListDto;
import com.example.api.dto.testDto.TestSearchCriteria;
import com.example.api.dto.testDto.TestUpdateDto;
import com.example.api.exception.NotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TestService {
    Page<TestListDto> getTests(Integer page, Integer pageSize, TestSearchCriteria testSearchCriteria);
    void createTest(TestCreateDto test);
    void updateTest(Long id, TestUpdateDto test) throws NotFoundException;
}
