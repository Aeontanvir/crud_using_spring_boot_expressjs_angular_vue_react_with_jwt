package com.aeontanvir.springblogs.exceptions;

import com.aeontanvir.springblogs.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handler(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error("Error: "+e.getMessage(), null));
    }
}
