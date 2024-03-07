package com.example.api.dto.candidateTestDto;


import com.example.api.dto.testDto.TestListDto;
import com.example.api.dto.testResultDto.TestResultDto;
import com.example.api.dto.candidateDto.CandidateListDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateTestListDto {
    private Long id;
    private CandidateListDto candidate;
    private TestListDto test;
    private List<TestResultDto> testResults;
}
