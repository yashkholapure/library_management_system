package com.example.libraryManagementSystem.advice;

import com.example.libraryManagementSystem.exception.ManageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class MyControllerAdvice {
    @ExceptionHandler(ManageException.BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(ManageException.BookNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ManageException.NoAvailableCopiesException.class)
    public ResponseEntity<String> handleNoAvailableCopiesException(ManageException.NoAvailableCopiesException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @ExceptionHandler(ManageException.UnExpectedException.class)
    public ResponseEntity<String> handleUnExpectedException(ManageException.UnExpectedException ex) {

        Throwable cause = ex.getCause();
        String message = ex.getMessage();
        String errorMessage = "";

        if (cause != null) {
            errorMessage = message + ": " + cause.getMessage();
        }
        log.info("borrow request");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
