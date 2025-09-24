package com.example.BookManagementSystem.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BookTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private double price;

    @Enumerated(EnumType.STRING)
    private GenreType genre;
    private LocalDate publishedyearanddate;


    public LocalDate getPublishedyearanddate() {
        return publishedyearanddate;
    }

    public void setPublishedyearanddate(LocalDate publishedyearanddate) {
        this.publishedyearanddate = publishedyearanddate;
    }

    public GenreType getGenre() {
        return genre;
    }

    public void setGenre(GenreType genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return "BookTable [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", genre=" + genre
                + ", publishedyearanddate=" + publishedyearanddate + "]";
    }
}
