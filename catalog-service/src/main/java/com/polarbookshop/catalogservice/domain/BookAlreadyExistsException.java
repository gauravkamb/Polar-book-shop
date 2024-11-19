package com.polarbookshop.catalogservice.domain;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String message) {
        super("A book with isbn -"+message+" already exists");
    }
}
