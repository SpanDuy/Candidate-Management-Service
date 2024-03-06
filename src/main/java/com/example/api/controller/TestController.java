package com.example.api.controller;

import com.example.api.dto.DirectionDto;
import com.example.api.dto.TestDto;
import com.example.api.dto.TestResultDto;
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
    private ResponseEntity<List<TestDto>> findAllTests() {
        List<TestDto> testDtos = testService.getTests();
        return new ResponseEntity<>(testDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createTest(@RequestBody TestDto testDto) {
        testService.createTest(testDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Void> updateTest(@RequestParam("id") Long id,
                                            @RequestBody TestDto testDto) {
        testService.updateTest(id, testDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
