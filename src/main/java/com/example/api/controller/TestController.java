package com.example.api.controller;

import com.example.api.dto.testDto.TestCreateDto;
import com.example.api.dto.testDto.TestListDto;
import com.example.api.dto.testDto.TestSearchCriteria;
import com.example.api.dto.testDto.TestUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.service.TestService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tests")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;
    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @PostMapping("/find")
    private ResponseEntity<Page<TestListDto>> findAllTests(@RequestParam(defaultValue = "0") @Valid @Min(0) Integer page,
                                                           @RequestParam(defaultValue = "5") @Valid @Min(1) Integer pageSize,
                                                           @RequestBody(required = false) TestSearchCriteria testSearchCriteria) {

        logger.info("Received request to find tests. Page: {}, PageSize: {}", page, pageSize);
        Page<TestListDto> testDtos = testService.getTests(page, pageSize, testSearchCriteria);
        logger.info("Found {} tests.", testDtos.getTotalElements());

        return new ResponseEntity<>(testDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createTest(@RequestBody @Valid TestCreateDto testDto) {

        logger.info("Received request to create a new test.");
        testService.createTest(testDto);
        logger.info("Test created successfully.");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Void> updateTest(@PathVariable("id") Long id,
                                            @RequestBody @Valid TestUpdateDto testDto) throws NotFoundException {

        logger.info("Received request to update test with ID: {}", id);
        testService.updateTest(id, testDto);
        logger.info("Test with ID {} updated successfully.", id);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
