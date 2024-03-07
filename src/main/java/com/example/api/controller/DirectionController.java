package com.example.api.controller;

import com.example.api.dto.directionDto.DirectionCreateDto;
import com.example.api.dto.directionDto.DirectionListDto;
import com.example.api.dto.directionDto.DirectionUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.service.DirectionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/directions")
@RequiredArgsConstructor
public class DirectionController {

    private final DirectionService directionService;

    @GetMapping("/all")
    private ResponseEntity<List<DirectionListDto>> findAllDirections() {
        List<DirectionListDto> directionDtos = directionService.getDirections();
        return new ResponseEntity<>(directionDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createDirection(@Valid @RequestBody DirectionCreateDto directionDto) {
        directionService.createDirection(directionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Void> updateDirection(@PathVariable("id") Long id,
                                                 @Valid @RequestBody DirectionUpdateDto directionDto) throws NotFoundException {
        directionService.updateDirection(id, directionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
