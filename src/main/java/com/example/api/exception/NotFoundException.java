package com.example.api.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NotFoundException extends Exception {
    private final String className;
    private final String message;
    @JsonIgnore
    private StackTraceElement[] stackTrace;
}
