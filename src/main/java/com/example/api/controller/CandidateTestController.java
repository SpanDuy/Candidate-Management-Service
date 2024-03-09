package com.example.api.controller;

import com.example.api.dto.candidateTestDto.CandidateTestCreateDto;
import com.example.api.dto.candidateTestDto.CandidateTestListDto;
import com.example.api.dto.candidateTestDto.CandidateTestSearchCriteria;
import com.example.api.dto.candidateTestDto.CandidateTestUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.service.CandidateTestService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/candidate-tests")
@RequiredArgsConstructor
public class CandidateTestController {

    private final CandidateTestService candidateTestService;
    private final Logger logger = LoggerFactory.getLogger(CandidateTestController.class);

    @PostMapping("/find")
    private ResponseEntity<Page<CandidateTestListDto>> findAllCandidateTests(@RequestParam(defaultValue = "0") @Valid @Min(0) Integer page,
                                                                             @RequestParam(defaultValue = "5") @Valid @Min(1) Integer pageSize,
                                                                             @RequestBody(required = false) CandidateTestSearchCriteria candidateTestSearchCriteria) {

        logger.info("Received request to find candidate tests. Page: {}, PageSize: {}", page, pageSize);
        Page<CandidateTestListDto> candidateTestDtos = candidateTestService.getCandidateTests(page, pageSize, candidateTestSearchCriteria);
        logger.info("Found {} candidate tests.", candidateTestDtos.getTotalElements());
        return new ResponseEntity<>(candidateTestDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createCandidateTest(@RequestBody @Valid CandidateTestCreateDto candidateTestDto) throws NotFoundException {

        logger.info("Received request to create a new candidate test.");
        candidateTestService.createCandidateTest(candidateTestDto);
        logger.info("Candidate test created successfully.");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Void> updateCandidateTest(@PathVariable("id") Long id,
                                                     @RequestBody @Valid CandidateTestUpdateDto candidateTestDto) throws NotFoundException {
        logger.info("Received request to update candidate test with ID: {}", id);
        candidateTestService.updateCandidateTest(id, candidateTestDto);
        logger.info("Candidate test with ID {} updated successfully.", id);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
