package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<String> books = new ArrayList<>();

    public void saveBook(String bookName) {
        if (books.contains(bookName)) {
            System.out.println("Book already exists: " + bookName);
        } else {
            books.add(bookName);
            System.out.println("Book saved: " + bookName);
        }
    }

    public String findBook(String bookName) {
        if (books.contains(bookName)) {
            return "Book found: " + bookName;
        } else {
            return "Book not found: " + bookName;
        }
    }

    public List<String> getAllBooks() {
        return books;
    }

    public boolean deleteBook(String bookName) {
        if (books.remove(bookName)) {
            System.out.println("Book deleted: " + bookName);
            return true;
        } else {
            System.out.println("Book not found: " + bookName);
            return false;
        }
    }
}
