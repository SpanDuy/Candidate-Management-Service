package com.example.api.controller;

import com.example.api.dto.CandidateTestDto;
import com.example.api.dto.DirectionDto;
import com.example.api.service.DirectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/directions")
@RequiredArgsConstructor
public class DirectionController {

    private final DirectionService directionService;

    @GetMapping("/all")
    private ResponseEntity<List<DirectionDto>> findAllDirections() {
        List<DirectionDto> directionDtos = directionService.getDirections();
        return new ResponseEntity<>(directionDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createDirection(@RequestBody DirectionDto directionDto) {
        directionService.createDirection(directionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Void> updateDirection(@RequestParam("id") Long id,
                                                 @RequestBody DirectionDto directionDto) {
        directionService.updateDirection(id, directionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
