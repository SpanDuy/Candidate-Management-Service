package com.example.api.service.impl;

import com.example.api.domain.Direction;
import com.example.api.dto.DirectionDto;
import com.example.api.repository.DirectionRepository;
import com.example.api.service.DirectionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DirectionServiceImpl implements DirectionService {

    private final DirectionRepository directionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DirectionDto> getDirections() {
        return directionRepository.findAll().stream()
                .map(direction -> modelMapper.map(direction, DirectionDto.class))
                .toList();
    }

    @Override
    public void createDirection(DirectionDto direction) {
        directionRepository.save(modelMapper.map(direction, Direction.class));
    }

    @Override
    public void updateDirection(Long id, DirectionDto direction) {
        directionRepository.save(modelMapper.map(direction, Direction.class));
    }
}
