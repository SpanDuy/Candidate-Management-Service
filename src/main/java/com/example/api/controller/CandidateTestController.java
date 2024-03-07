package com.example.api.controller;

import com.example.api.dto.candidateTestDto.CandidateTestCreateDto;
import com.example.api.dto.candidateTestDto.CandidateTestListDto;
import com.example.api.dto.candidateTestDto.CandidateTestUpdateDto;
import com.example.api.exception.NotFoundException;
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
    private ResponseEntity<List<CandidateTestListDto>> findAllCandidateTests() {
        List<CandidateTestListDto> candidateTestDtos = candidateTestService.getCandidateTests();
        return new ResponseEntity<>(candidateTestDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createCandidateTest(@RequestBody CandidateTestCreateDto candidateTestDto) throws NotFoundException {
        candidateTestService.createCandidateTest(candidateTestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Void> updateCandidateTest(@PathVariable("id") Long id,
                                                     @RequestBody CandidateTestUpdateDto candidateTestDto) throws NotFoundException {
        candidateTestService.updateCandidateTest(id, candidateTestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
