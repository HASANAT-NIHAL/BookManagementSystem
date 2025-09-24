package com.example.BookManagementSystem.Service;

import com.example.BookManagementSystem.Entity.BookTable;
import com.example.BookManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookTable> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookTable getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public BookTable findByTitle( String title) {
        return bookRepository.findByTitle(title).orElse(null);
    }

    public String addbook( BookTable book) {
//        BookTable isBook = getBookById(book.getId());
//        if (isBook == null) {
            bookRepository.save(book);
            return  "Book is added successfully";
//            return "Book is added successfully";
//        }
//        else {
//            return "Book is already present";
//        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
