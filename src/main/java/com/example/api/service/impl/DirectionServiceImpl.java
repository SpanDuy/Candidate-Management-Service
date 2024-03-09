package com.example.api.service.impl;

import com.example.api.domain.Direction;
import com.example.api.dto.directionDto.DirectionCreateDto;
import com.example.api.dto.directionDto.DirectionListDto;
import com.example.api.dto.directionDto.DirectionSearchCriteria;
import com.example.api.dto.directionDto.DirectionUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.repository.DirectionRepository;
import com.example.api.repository.specification.DirectionSpecifications;
import com.example.api.service.DirectionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectionServiceImpl implements DirectionService {

    private final DirectionRepository directionRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<DirectionListDto> getDirections(Integer page, Integer pageSize, DirectionSearchCriteria directionSearchCriteria) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Direction> directions;

        if (directionSearchCriteria == null) {
            directions = directionRepository.findAll(pageRequest);
        } else {
            Specification<Direction> spec = Specification
                    .where(DirectionSpecifications.nameLike(directionSearchCriteria.getName()))
                    .and(DirectionSpecifications.descriptionLike(directionSearchCriteria.getDescription()));

            directions = directionRepository.findAll(spec, pageRequest);
        }

        return directions.map(direction -> modelMapper.map(direction, DirectionListDto.class));
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
