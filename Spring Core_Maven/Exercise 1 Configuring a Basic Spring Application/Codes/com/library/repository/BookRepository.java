package com.library.repository;

// This is a simple repository class to simulate database operations.
public class BookRepository {

    public BookRepository() {
        System.out.println("BookRepository bean created by Spring!");
    }

    public void fetchBooks() {
        System.out.println("Fetching books from the database...");
    }
}