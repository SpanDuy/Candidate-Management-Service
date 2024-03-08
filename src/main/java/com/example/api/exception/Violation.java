package com.example.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public record Violation(String fieldName, String message) {

}
