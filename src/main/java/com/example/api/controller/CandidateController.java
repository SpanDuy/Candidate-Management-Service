package com.example.api.controller;

import com.example.api.domain.Candidate;
import com.example.api.dto.CandidateDto;
import com.example.api.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping("/all")
    private ResponseEntity<List<CandidateDto>> findAllCandidates() {
        List<CandidateDto> candidateDtos = candidateService.getCandidates();
        return new ResponseEntity<>(candidateDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createCandidate(@RequestBody CandidateDto candidateDto) {
        candidateService.createCandidate(candidateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Void> updateCandidate(@RequestParam("id") Long id,
                                                 @RequestBody CandidateDto candidateDto) {
        candidateService.updateCandidate(id, candidateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
