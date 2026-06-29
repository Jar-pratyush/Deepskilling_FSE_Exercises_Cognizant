package com.library.service;

// This is the service class that contains business logic.
public class BookService {

    public BookService() {
        System.out.println("BookService bean created by Spring!");
    }

    public void displayServiceStatus() {
        System.out.println("BookService is active and ready.");
    }
}