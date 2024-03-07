package com.example.api.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private List<Direction> applicableDirections;

    public void setNotNullFields(Test newTest) {
        if (newTest.name != null) {
            this.name = newTest.name;
        }
        if (newTest.description != null) {
            this.description = newTest.description;
        }
    }
}