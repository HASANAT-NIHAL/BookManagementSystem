package com.example.BookManagementSystem.Repository;

import com.example.BookManagementSystem.Entity.BookTable;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookTable, Long> {
    Optional<BookTable> findByTitle(String title);


}
