package com.example.librarymanagement;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryManagementApplication {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(LibraryManagementApplication.class)) {
            LibraryService service = context.getBean(LibraryService.class);
            System.out.println(service.greet());
        }
    }

    @Bean
    public LibraryService libraryService() {
        return new LibraryService();
    }

    public static class LibraryService {
        public String greet() {
            return "Library management application is ready!";
        }
    }
}
