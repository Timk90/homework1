package com.myhomework.javaclasses.homework3.library;

/**
 * Исключение, возникающее при попытке добавить книгу.
 */
public class TakeBookException extends RuntimeException {
    public TakeBookException() {
    }

    public TakeBookException(String message) {
        super(message);
    }

    public TakeBookException(String message, Book book) {
        super(message);
        System.out.println(book);
    }

    public TakeBookException(String message, Throwable cause) {
        super(message, cause);
    }

}
