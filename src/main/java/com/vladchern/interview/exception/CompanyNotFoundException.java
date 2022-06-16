package com.vladchern.interview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

/**
 * Исключение, бросаемое, если при поиске организации по ID такой записи не нашлось в базе данных.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends RuntimeException {

    public CompanyNotFoundException(UUID id) {
        super("Company with id = " + id + " was not found in database");
    }
}
