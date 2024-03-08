package com.example.api.controller;

import com.example.api.dto.candidateDto.CandidateCreateDto;
import com.example.api.dto.candidateDto.CandidateListDto;
import com.example.api.dto.candidateDto.CandidateSearchCriteria;
import com.example.api.dto.candidateDto.CandidateUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping("/find")
    private ResponseEntity<Page<CandidateListDto>> findAllCandidates(@RequestParam(defaultValue = "0") Integer page,
                                                                     @RequestParam(defaultValue = "5") Integer pageSize,
                                                                     @RequestBody CandidateSearchCriteria candidateSearchCriteria) {
        Page<CandidateListDto> candidateDtos = candidateService.getCandidates(page, pageSize, candidateSearchCriteria);
        return new ResponseEntity<>(candidateDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createCandidate(@RequestBody CandidateCreateDto candidateDto) {
        candidateService.createCandidate(candidateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Void> updateCandidate(@PathVariable("id") Long id,
                                                 @RequestBody CandidateUpdateDto candidateDto) throws NotFoundException {
        candidateService.updateCandidate(id, candidateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
