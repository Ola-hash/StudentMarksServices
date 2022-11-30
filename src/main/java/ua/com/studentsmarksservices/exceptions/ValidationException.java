package ua.com.studentsmarksservices.exceptions;

import lombok.ToString;

@ToString
public class ValidationException extends RuntimeException {
    private final String message;

    public ValidationException(String message) {
        this.message = message;
    }
}
