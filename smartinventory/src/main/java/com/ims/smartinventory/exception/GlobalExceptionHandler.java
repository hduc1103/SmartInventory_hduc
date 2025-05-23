package com.ims.smartinventory.exception;

import com.ims.smartinventory.dto.Response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuitableSectionException.class)
    public ResponseEntity<ErrorResponse> handleNoSuitableSectionException(NoSuitableSectionException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), "NO_SUITABLE_SECTION");
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<ErrorResponse> handleStorageException(StorageException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), "STORAGE_ERROR");
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred. Please contact administrator.", "INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
