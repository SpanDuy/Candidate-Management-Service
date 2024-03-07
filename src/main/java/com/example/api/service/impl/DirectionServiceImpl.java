package com.example.api.service.impl;

import com.example.api.domain.Direction;
import com.example.api.dto.directionDto.DirectionCreateDto;
import com.example.api.dto.directionDto.DirectionListDto;
import com.example.api.dto.directionDto.DirectionUpdateDto;
import com.example.api.exception.NotFoundException;
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
    public List<DirectionListDto> getDirections() {
        return directionRepository.findAll().stream()
                .map(direction -> modelMapper.map(direction, DirectionListDto.class))
                .toList();
    }

    @Override
    public void createDirection(DirectionCreateDto direction) {
        directionRepository.save(modelMapper.map(direction, Direction.class));
    }

    @Override
    public void updateDirection(Long id, DirectionUpdateDto directionDto) throws NotFoundException {
        Direction direction = directionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Direction", "Entity with id = " + id + "Not found"));

        direction.setNotNullFields(modelMapper.map(directionDto, Direction.class));

        directionRepository.save(modelMapper.map(direction, Direction.class));
    }
}
