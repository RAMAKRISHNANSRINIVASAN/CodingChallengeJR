package com.example.demo;



import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Service.BookService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    private Book testBook;

    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll(); // Clear all books to avoid duplicates

        testBook = new Book();
        testBook.setTitle("Test Title");
        testBook.setAuthor("Test Author");
        testBook.setIsbn("1234567890123");
        testBook.setPublicationYear(2021);

        // Save the book in the repository for testing
        bookRepository.save(testBook);
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book();
        newBook.setTitle("New Book");
        newBook.setAuthor("New Author");
        newBook.setIsbn("9876543210987");
        newBook.setPublicationYear(2022);

        Book savedBook = bookService.addBook(newBook);

        assertEquals("New Book", savedBook.getTitle());
        assertEquals("New Author", savedBook.getAuthor());
        assertEquals("9876543210987", savedBook.getIsbn());
    }


    @Test
    public void testGetBookByIsbn() {
        // Retrieve the book by ISBN
        Book retrievedBook = bookService.getBookByIsbn("1234567890123");

        // Validate the retrieved book's properties
        assertEquals("Test Title", retrievedBook.getTitle());
        assertEquals("Test Author", retrievedBook.getAuthor());
        assertEquals("1234567890123", retrievedBook.getIsbn());
    }

   
    @Test
    public void testDeleteBookByIsbn() {
        bookService.deleteBookByIsbn("1234567890123");

        Optional<Book> deletedBook = bookRepository.findByIsbn("1234567890123");
        assertTrue(deletedBook.isEmpty());
    }
}
