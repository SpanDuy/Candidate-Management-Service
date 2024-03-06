package com.example.api.service.impl;

import com.example.api.domain.Test;
import com.example.api.dto.TestDto;
import com.example.api.repository.TestRepository;
import com.example.api.service.TestResultService;
import com.example.api.service.TestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TestDto> getTests() {
        return testRepository.findAll().stream()
                .map(test -> modelMapper.map(test, TestDto.class))
                .toList();
    }

    @Override
    public void createTest(TestDto test) {
        testRepository.save(modelMapper.map(test, Test.class));
    }

    @Override
    public void updateTest(Long id, TestDto test) {
        testRepository.save(modelMapper.map(test, Test.class));
    }
}
