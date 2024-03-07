package com.example.api.controller;

import com.example.api.dto.testDto.TestCreateDto;
import com.example.api.dto.testDto.TestListDto;
import com.example.api.dto.testDto.TestUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tests")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/all")
    private ResponseEntity<List<TestListDto>> findAllTests() {
        List<TestListDto> testDtos = testService.getTests();
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
