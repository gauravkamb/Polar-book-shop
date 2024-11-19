package com.polarbookshop.catalogservice.domain;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super("A book with isbn -"+message+" was not found");
    }
}
