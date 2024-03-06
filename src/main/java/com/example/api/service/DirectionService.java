package com.example.api.service;

import com.example.api.domain.CandidateTest;
import com.example.api.domain.Direction;
import com.example.api.dto.DirectionDto;

import java.util.List;

public interface DirectionService {
    List<DirectionDto> getDirections();
    void createDirection(DirectionDto direction);
    void updateDirection(Long id, DirectionDto direction);
}
