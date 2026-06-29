package com.library.repository;

// The repository acts as a dependency for the service.
public class BookRepository {

    public String getAvailableBooks() {
        return "List of Books: [Java Fundamentals, Spring Boot in Action, React Design Patterns]";
    }
}