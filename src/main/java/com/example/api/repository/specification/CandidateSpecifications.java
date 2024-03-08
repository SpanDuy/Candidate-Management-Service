package com.example.api.repository.specification;

import com.example.api.domain.Candidate;
import com.example.api.domain.Test;
import org.springframework.data.jpa.domain.Specification;

public class CandidateSpecifications {

    public static Specification<Candidate> firstNameLike(String firstName) {
        return (root, query, criteriaBuilder) -> {
            if (firstName == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%");
        };
    }

    public static Specification<Candidate> lastNameLike(String lastName) {
        return (root, query, criteriaBuilder) -> {
            if (lastName == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%");
        };
    }

    public static Specification<Candidate> middleNameLike(String middleName) {
        return (root, query, criteriaBuilder) -> {
            if (middleName == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.like(root.get("middleName"), "%" + middleName + "%");
        };
    }

    public static Specification<Candidate> photoLike(String photo) {
        return (root, query, criteriaBuilder) -> {
            if (photo == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.like(root.get("photo"), "%" + photo + "%");
        };
    }

    public static Specification<Candidate> descriptionLike(String description) {
        return (root, query, criteriaBuilder) -> {
            if (description == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.like(root.get("description"), "%" + description + "%");
        };
    }

    public static Specification<Candidate> cvFileLike(String cvFile) {
        return (root, query, criteriaBuilder) -> {
            if (cvFile == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.like(root.get("cvFile"), "%" + cvFile + "%");
        };
    }
}
