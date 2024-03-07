package com.example.api.dto.candidateTestDto;


import com.example.api.dto.testResultDto.TestResultDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateTestUpdateDto {
    @NotNull
    private Long id;
    private Long candidate;
    private Long test;
    private List<TestResultDto> testResults;
}
