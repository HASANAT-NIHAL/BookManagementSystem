package com.example.BookManagementSystem.Controller;

import com.example.BookManagementSystem.Entity.BookTable;
import com.example.BookManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookControllers {

    @Autowired
    private BookService bookService;

    @GetMapping("/getallbooks")
    public List<BookTable> getAllBooksctrl() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getbookbyid,{id}")
    public BookTable getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/addbook")
    public void addbook(@RequestBody BookTable book) {
        bookService.addbook(book);
    }

    @PutMapping("/updatebook/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody BookTable updatedBook) {
//        BookTable existingBook = bookService.getBookById(id);
        BookTable existingBook = bookService.getBookById(id);
        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setPublishedyearanddate(updatedBook.getPublishedyearanddate());
            bookService.addbook(existingBook);
            return "Book updated successfully";
        } else {
            return "Book not found";
        }
    }

    @DeleteMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable Long id) {
        BookTable existingBook = bookService.getBookById(id);
        if (existingBook != null) {
            bookService.deleteBook(id);
            return "Book deleted successfully";
        } else {
            return "Book not found";
        }
    }
}