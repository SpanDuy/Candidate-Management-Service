package com.example.api.service;

import com.example.api.dto.directionDto.DirectionCreateDto;
import com.example.api.dto.directionDto.DirectionListDto;
import com.example.api.dto.directionDto.DirectionUpdateDto;
import com.example.api.exception.NotFoundException;

import java.util.List;

public interface DirectionService {
    List<DirectionListDto> getDirections();
    void createDirection(DirectionCreateDto direction);
    void updateDirection(Long id, DirectionUpdateDto direction) throws NotFoundException;
}
