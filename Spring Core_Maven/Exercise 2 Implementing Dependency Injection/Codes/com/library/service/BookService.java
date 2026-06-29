package com.library.service;
import com.library.repository.BookRepository;

// The service relies on the repository, injected via Spring DI.
public class BookService {

    private BookRepository bookRepository;

    // Setter method required for Spring's Setter-based Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Spring DI: BookRepository successfully injected into BookService!");
    }

    public void processBookCheckout() {
        System.out.println("Processing checkout...");
        // Using the injected dependency
        System.out.println(bookRepository.getAvailableBooks());
    }
}