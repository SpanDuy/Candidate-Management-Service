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
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String photo;

    private String description;

    private String cvFile;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private List<Direction> possibleDirections;

    public void setNotNullFields(Candidate newCandidate) {
        if (newCandidate.firstName != null) {
            this.firstName = newCandidate.firstName;
        }
        if (newCandidate.lastName != null) {
            this.lastName = newCandidate.lastName;
        }
        if (newCandidate.middleName != null) {
            this.middleName = newCandidate.middleName;
        }
        if (newCandidate.photo != null) {
            this.photo = newCandidate.photo;
        }
        if (newCandidate.description != null) {
            this.description = newCandidate.description;
        }
        if (newCandidate.cvFile != null) {
            this.cvFile = newCandidate.cvFile;
        }
    }
}
