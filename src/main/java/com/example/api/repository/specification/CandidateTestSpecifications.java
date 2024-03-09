package com.example.api.repository.specification;

import com.example.api.domain.CandidateTest;
import com.example.api.dto.candidateTestDto.CandidateTestSearchCriteria;
import com.example.api.dto.testResultDto.TestResultSearchCriteria;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CandidateTestSpecifications {

    public static Specification<CandidateTest> withSearchCriteria(CandidateTestSearchCriteria searchCriteria) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (searchCriteria.getTestResults() != null) {
                predicates.addAll(getTestResultPredicates(root, builder, searchCriteria.getTestResults()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    private static List<Predicate> getTestResultPredicates(
            Root<CandidateTest> root,
            CriteriaBuilder builder,
            TestResultSearchCriteria testResultsCriteria
    ) {
        List<Predicate> predicates = new ArrayList<>();

        if (testResultsCriteria.getDateGt() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("testResults").get("date"), testResultsCriteria.getDateGt()));
        }

        if (testResultsCriteria.getDateLt() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("testResults").get("date"), testResultsCriteria.getDateLt()));
        }

        if (testResultsCriteria.getGrade() != null) {
            predicates.add(builder.equal(root.get("testResults").get("grade"), testResultsCriteria.getGrade()));
        }

        return predicates;
    }
}

