package com.anime.api.animejavaapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    private ResponseEntity<Object>handleApiException(ApiRequestException e){
        ApiException apiException = new ApiException(e.getMessage(),e, HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    private ResponseEntity<Object>handleApiException(NotFoundException e){
        ApiException apiException = new ApiException(e.getMessage(),e, HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(apiException,HttpStatus.NOT_FOUND);
    }
}
