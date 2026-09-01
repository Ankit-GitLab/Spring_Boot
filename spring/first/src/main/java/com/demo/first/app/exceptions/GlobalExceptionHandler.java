package com.demo.first.app.exceptions;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // EXCEPTION HANDLING METHOD
    @ExceptionHandler({UserNotFoundException.class,IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(Exception exception){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error","Bad request");
        errorResponse.put("message",exception.getMessage());
        return new  ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    /*
* {
    "timestamp": "2026-08-31T05:32:40.687Z",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/user"
}
* */

    //EXCEPTION HANDLING METHOD
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleMethodNotSupported(Exception exception){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.METHOD_NOT_ALLOWED.value());
        errorResponse.put("error","method not allowed on this end point");
        errorResponse.put("message",exception.getMessage());
        return new  ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }
    /*
    * {
    "error": "method not allowed on this end point",
    "message": "Request method 'POST' is not supported",
    "timestamp": "2026-08-31T13:04:10.7653568",
    "status": 405
}*/
}
