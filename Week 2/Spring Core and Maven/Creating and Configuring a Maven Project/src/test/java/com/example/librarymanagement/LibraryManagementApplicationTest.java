package com.example.librarymanagement;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LibraryManagementApplicationTest {

    @Test
    void contextLoads() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(LibraryManagementApplication.class)) {
            LibraryManagementApplication.LibraryService service = context.getBean(LibraryManagementApplication.LibraryService.class);
            assertNotNull(service);
        }
    }
}
