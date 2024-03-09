package com.example.api.controller;

import com.example.api.dto.candidateDto.CandidateCreateDto;
import com.example.api.dto.candidateDto.CandidateListDto;
import com.example.api.dto.candidateDto.CandidateSearchCriteria;
import com.example.api.dto.candidateDto.CandidateUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.service.CandidateService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;
    private final Logger logger = LoggerFactory.getLogger(CandidateController.class);

    @PostMapping("/find")
    private ResponseEntity<Page<CandidateListDto>> findAllCandidates(@RequestParam(defaultValue = "0") @Valid @Min(0) Integer page,
                                                                     @RequestParam(defaultValue = "5") @Valid @Min(1) Integer pageSize,
                                                                     @RequestBody(required = false) CandidateSearchCriteria candidateSearchCriteria) {

        logger.info("Received request to find candidates. Page: {}, PageSize: {}", page, pageSize);
        Page<CandidateListDto> candidateDtos = candidateService.getCandidates(page, pageSize, candidateSearchCriteria);
        logger.info("Found {} candidates.", candidateDtos.getTotalElements());

        return new ResponseEntity<>(candidateDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createCandidate(@RequestBody @Valid CandidateCreateDto candidateDto) {

        logger.info("Received request to create a new candidate.");
        candidateService.createCandidate(candidateDto);
        logger.info("Candidate created successfully.");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Void> updateCandidate(@PathVariable("id") Long id,
                                                 @RequestBody @Valid CandidateUpdateDto candidateDto) throws NotFoundException {

        logger.info("Received request to update candidate with ID: {}", id);
        candidateService.updateCandidate(id, candidateDto);
        logger.info("Candidate with ID {} updated successfully.", id);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
