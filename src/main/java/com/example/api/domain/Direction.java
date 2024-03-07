package com.example.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;

    public void setNotNullFields(Direction newDirection) {
        if (newDirection.name != null) {
            this.name = newDirection.name;
        }
        if (newDirection.description != null) {
            this.description = newDirection.description;
        }
    }
}
