package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Load the Spring context from applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean from the context
        BookService bookService = (BookService) context.getBean("bookService");

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Menu-driven interface
        while (true) {
            System.out.println("\n=== Library Management Application ===");
            System.out.println("1. Add a book");
            System.out.println("2. List all books");
            System.out.println("3. Find a book");
            System.out.println("4. Delete a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the book name: ");
                    String bookName = scanner.nextLine();
                    bookService.addBook(bookName);
                    break;

                case 2:
                    List<String> books = bookService.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books in the library.");
                    } else {
                        System.out.println("=== All Books ===");
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println((i + 1) + ". " + books.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the book name to find: ");
                    String findName = scanner.nextLine();
                    String result = bookService.getBook(findName);
                    System.out.println(result);
                    break;

                case 4:
                    System.out.print("Enter the book name to delete: ");
                    String deleteName = scanner.nextLine();
                    boolean deleted = bookService.deleteBook(deleteName);
                    if (deleted) {
                        System.out.println("Book deleted successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting application...");
                    scanner.close();
                    ((ClassPathXmlApplicationContext) context).close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
