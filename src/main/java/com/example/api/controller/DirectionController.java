package com.example.api.controller;

import com.example.api.dto.directionDto.DirectionCreateDto;
import com.example.api.dto.directionDto.DirectionListDto;
import com.example.api.dto.directionDto.DirectionSearchCriteria;
import com.example.api.dto.directionDto.DirectionUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.service.DirectionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/directions")
@RequiredArgsConstructor
public class DirectionController {

    private final DirectionService directionService;

    @PostMapping("/find")
    private ResponseEntity<Page<DirectionListDto>> findAllDirections(@RequestParam(defaultValue = "0") Integer page,
                                                                     @RequestParam(defaultValue = "5") Integer pageSize,
                                                                     @RequestBody DirectionSearchCriteria directionSearchCriteria) {
        Page<DirectionListDto> directionDtos = directionService.getDirections(page, pageSize, directionSearchCriteria);
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
