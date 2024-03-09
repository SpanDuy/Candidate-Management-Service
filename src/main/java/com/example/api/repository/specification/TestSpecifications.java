package com.example.api.repository.specification;

import com.example.api.domain.Test;
import org.springframework.data.jpa.domain.Specification;

public class TestSpecifications {
    public static Specification<Test> nameLike(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    public static Specification<Test> descriptionLike(String description) {
        return (root, query, criteriaBuilder) -> {
            if (description == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.like(root.get("description"), "%" + description + "%");
        };
    }
}
