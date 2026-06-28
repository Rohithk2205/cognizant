package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    // Constructor for dependency injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        bookRepository.saveBook(bookName);
    }

    public String getBook(String bookName) {
        return bookRepository.findBook(bookName);
    }

    public List<String> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public boolean deleteBook(String bookName) {
        return bookRepository.deleteBook(bookName);
    }
}
