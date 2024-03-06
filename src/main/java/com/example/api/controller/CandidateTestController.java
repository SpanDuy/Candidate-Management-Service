package com.example.api.controller;

import com.example.api.dto.CandidateDto;
import com.example.api.dto.CandidateTestDto;
import com.example.api.service.CandidateTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/candidate-tests")
@RequiredArgsConstructor
public class CandidateTestController {

    private final CandidateTestService candidateTestService;

    @GetMapping("/all")
    private ResponseEntity<List<CandidateTestDto>> findAllCandidateTests() {
        List<CandidateTestDto> candidateTestDtos = candidateTestService.getCandidateTests();
        return new ResponseEntity<>(candidateTestDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createCandidateTest(@RequestBody CandidateTestDto candidateTestDto) {
        candidateTestService.createCandidateTest(candidateTestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Void> updateCandidateTest(@RequestParam("id") Long id,
                                                     @RequestBody CandidateTestDto candidateTestDto) {
        candidateTestService.updateCandidateTest(id, candidateTestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
