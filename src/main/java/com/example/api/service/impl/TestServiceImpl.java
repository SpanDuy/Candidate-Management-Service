package com.example.api.service.impl;

import com.example.api.domain.Direction;
import com.example.api.domain.Test;
import com.example.api.dto.directionDto.DirectionListDto;
import com.example.api.dto.directionDto.DirectionSearchCriteria;
import com.example.api.dto.testDto.TestCreateDto;
import com.example.api.dto.testDto.TestListDto;
import com.example.api.dto.testDto.TestSearchCriteria;
import com.example.api.dto.testDto.TestUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.repository.DirectionRepository;
import com.example.api.repository.TestRepository;
import com.example.api.repository.specification.DirectionSpecifications;
import com.example.api.repository.specification.TestSpecifications;
import com.example.api.service.TestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;
    private final DirectionRepository directionRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<TestListDto> getTests(Integer page, Integer pageSize, TestSearchCriteria testSearchCriteria) {
        Specification<Test> spec = Specification
                .where(TestSpecifications.nameLike(testSearchCriteria.getName()))
                .and(TestSpecifications.descriptionLike(testSearchCriteria.getDescription()));

        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Test> tests = testRepository.findAll(spec, pageRequest);

        return tests.map(test -> modelMapper.map(test, TestListDto.class));
    }

    @Override
    public void createTest(TestCreateDto testDto) {
        List<Direction> directions = directionRepository.findAllById(testDto.getApplicableDirections());
        Test test = modelMapper.map(testDto, Test.class);
        test.setApplicableDirections(directions);
        testRepository.save(test);
    }

    @Override
    public void updateTest(Long id, TestUpdateDto testDto) throws NotFoundException {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Test", "Entity with id = " + id + "Not found"));

        List<Direction> directions = directionRepository.findAllById(testDto.getApplicableDirections());
        test.setNotNullFields(modelMapper.map(testDto, Test.class));
        test.setApplicableDirections(directions);

        testRepository.save(test);
    }
}
