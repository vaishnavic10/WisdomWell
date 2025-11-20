package com.library.service;

import com.library.exceptions.InvalidInputException;

public class ValidationService {

    public void validateString(String value) {
        if (value == null || value.trim().isEmpty())
            throw new InvalidInputException("Invalid input");
    }

    public void validateEmail(String email) {
        if (!email.contains("@") || !email.contains("."))
            throw new InvalidInputException("Invalid email");
    }
}
