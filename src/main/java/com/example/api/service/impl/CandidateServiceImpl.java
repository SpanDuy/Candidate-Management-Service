package com.example.api.service.impl;

import com.example.api.domain.Candidate;
import com.example.api.domain.Direction;
import com.example.api.dto.candidateDto.CandidateCreateDto;
import com.example.api.dto.candidateDto.CandidateListDto;
import com.example.api.dto.candidateDto.CandidateSearchCriteria;
import com.example.api.dto.candidateDto.CandidateUpdateDto;
import com.example.api.exception.NotFoundException;
import com.example.api.repository.CandidateRepository;
import com.example.api.repository.DirectionRepository;
import com.example.api.repository.specification.CandidateSpecifications;
import com.example.api.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final DirectionRepository directionRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<CandidateListDto> getCandidates(Integer page, Integer pageSize, CandidateSearchCriteria candidateSearchCriteria) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Candidate> candidates;

        if (candidateSearchCriteria == null) {
            candidates = candidateRepository.findAll(pageRequest);
        } else {
            Specification<Candidate> spec = Specification
                    .where(CandidateSpecifications.firstNameLike(candidateSearchCriteria.getFirstName()))
                    .and(CandidateSpecifications.lastNameLike(candidateSearchCriteria.getLastName()))
                    .and(CandidateSpecifications.middleNameLike(candidateSearchCriteria.getMiddleName()))
                    .and(CandidateSpecifications.photoLike(candidateSearchCriteria.getPhoto()))
                    .and(CandidateSpecifications.descriptionLike(candidateSearchCriteria.getDescription()))
                    .and(CandidateSpecifications.cvFileLike(candidateSearchCriteria.getCvFile()));

            candidates = candidateRepository.findAll(spec, pageRequest);
        }

        return candidates.map(candidate -> modelMapper.map(candidate, CandidateListDto.class));
    }

    @Override
    public void createCandidate(CandidateCreateDto candidateDto) {
        List<Direction> directions = directionRepository.findAllById(candidateDto.getPossibleDirections());
        Candidate candidate = modelMapper.map(candidateDto, Candidate.class);
        candidate.setPossibleDirections(directions);

        candidateRepository.save(candidate);
    }

    @Override
    public void updateCandidate(Long id, CandidateUpdateDto candidateDto) throws NotFoundException {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Candidate", "Entity with id = " + id + "Not found"));

        candidate.setNotNullFields(modelMapper.map(candidateDto, Candidate.class));
        if (candidateDto.getPossibleDirections() != null) {
            List<Direction> directions = directionRepository.findAllById(candidateDto.getPossibleDirections());
            candidate.setPossibleDirections(directions);
        }

        candidateRepository.save(modelMapper.map(candidate, Candidate.class));
    }
}
