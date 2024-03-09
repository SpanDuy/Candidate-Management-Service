package com.example.api.exception;

import java.util.List;

public record ValidationErrorResponse(List<Violation> violations) {

}
