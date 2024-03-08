package com.example.api.controller;

import com.example.api.dto.directionDto.DirectionSearchCriteria;
import com.example.api.dto.testDto.TestCreateDto;
import com.example.api.dto.testDto.TestListDto;
import com.example.api.dto.testDto.TestSearchCriteria;
import com.example.api.dto.testDto.TestUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tests")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/find")
    private ResponseEntity<Page<TestListDto>> findAllTests(@RequestParam(defaultValue = "0") Integer page,
                                                           @RequestParam(defaultValue = "5") Integer pageSize,
                                                           @RequestBody(required = false) TestSearchCriteria testSearchCriteria) {
        Page<TestListDto> testDtos = testService.getTests(page, pageSize, testSearchCriteria);
        return new ResponseEntity<>(testDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createTest(@RequestBody TestCreateDto testDto) {
        testService.createTest(testDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Void> updateTest(@PathVariable("id") Long id,
                                            @RequestBody TestUpdateDto testDto) throws NotFoundException {
        testService.updateTest(id, testDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
