package com.example.api.controller;

import com.example.api.dto.directionDto.DirectionCreateDto;
import com.example.api.dto.directionDto.DirectionListDto;
import com.example.api.dto.directionDto.DirectionSearchCriteria;
import com.example.api.dto.directionDto.DirectionUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.service.DirectionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(DirectionController.class);

    @PostMapping("/find")
    private ResponseEntity<Page<DirectionListDto>> findAllDirections(@RequestParam(defaultValue = "0") @Valid @Min(0) Integer page,
                                                                     @RequestParam(defaultValue = "5") @Valid @Min(1) Integer pageSize,
                                                                     @RequestBody(required = false) DirectionSearchCriteria directionSearchCriteria) {

        logger.info("Received request to find directions. Page: {}, PageSize: {}", page, pageSize);
        Page<DirectionListDto> directionDtos = directionService.getDirections(page, pageSize, directionSearchCriteria);
        logger.info("Found {} directions.", directionDtos.getTotalElements());

        return new ResponseEntity<>(directionDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createDirection(@RequestBody @Valid DirectionCreateDto directionDto) {

        logger.info("Received request to create a new direction.");
        directionService.createDirection(directionDto);
        logger.info("Direction created successfully.");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Void> updateDirection(@PathVariable("id") Long id,
                                                 @RequestBody @Valid DirectionUpdateDto directionDto) throws NotFoundException {

        logger.info("Received request to update direction with ID: {}", id);
        directionService.updateDirection(id, directionDto);
        logger.info("Direction with ID {} updated successfully.", id);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
