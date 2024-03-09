package com.example.api.service;

import com.example.api.dto.directionDto.DirectionCreateDto;
import com.example.api.dto.directionDto.DirectionListDto;
import com.example.api.dto.directionDto.DirectionSearchCriteria;
import com.example.api.dto.directionDto.DirectionUpdateDto;
import com.example.api.exception.NotFoundException;
import org.springframework.data.domain.Page;

public interface DirectionService {
    Page<DirectionListDto> getDirections(Integer page, Integer pageSize, DirectionSearchCriteria directionSearchCriteria);
    void createDirection(DirectionCreateDto direction);
    void updateDirection(Long id, DirectionUpdateDto direction) throws NotFoundException;
}
