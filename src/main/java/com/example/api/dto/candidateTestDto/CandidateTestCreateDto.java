package com.example.api.dto.candidateTestDto;


import com.example.api.dto.testResultDto.TestResultDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateTestCreateDto {
    @NotNull
    private Long candidate;
    @NotNull
    private Long test;
    @NotEmpty
    private List<TestResultDto> testResults;
}
