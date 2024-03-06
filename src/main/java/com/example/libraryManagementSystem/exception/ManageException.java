package com.example.libraryManagementSystem.exception;

public class ManageException {
    public static class BookNotFoundException extends RuntimeException {
        public BookNotFoundException(String message) {
            super(message);
        }
    }

    public static class NoAvailableCopiesException extends RuntimeException {
        public NoAvailableCopiesException(String message) {
            super(message);
        }
    }

    public static class UnExpectedException extends RuntimeException {
        public UnExpectedException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
