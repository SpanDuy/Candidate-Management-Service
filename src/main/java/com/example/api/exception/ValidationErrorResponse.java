package com.example.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

public record ValidationErrorResponse(List<Violation> violations) {

}
