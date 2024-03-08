package com.example.api.repository;

import com.example.api.domain.Direction;
import com.example.api.dto.directionDto.DirectionSearchCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long>, JpaSpecificationExecutor<Direction> {
}