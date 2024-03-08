package com.example.api.controller;

import com.example.api.dto.candidateTestDto.CandidateTestCreateDto;
import com.example.api.dto.candidateTestDto.CandidateTestListDto;
import com.example.api.dto.candidateTestDto.CandidateTestSearchCriteria;
import com.example.api.dto.candidateTestDto.CandidateTestUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.service.CandidateTestService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/find")
    private ResponseEntity<Page<CandidateTestListDto>> findAllCandidateTests(@RequestParam(defaultValue = "0") Integer page,
                                                                             @RequestParam(defaultValue = "5") Integer pageSize,
                                                                             @RequestBody CandidateTestSearchCriteria candidateTestSearchCriteria) {
        Page<CandidateTestListDto> candidateTestDtos = candidateTestService.getCandidateTests(page, pageSize, candidateTestSearchCriteria);
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
