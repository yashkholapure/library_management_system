package com.example.libraryManagementSystem.entity;

import jakarta.persistence.*;

import java.time.Year;

@Entity
public class LibraryEntity {
    @Id  //making primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long book_id;
    @Column(name = "book_title")
    private String book_title;
    @Column(name = "author")
    private String author;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publication_year")
    private String publication_year;

    @Column(name = "genre")
    private String genre;
    @Column(name = "quantity")
    private long quantity;
    @Column(name = "available")
    private long available;


    public LibraryEntity() {
        // Default constructor
    }

    public LibraryEntity(Long book_id, String book_title, String author, String isbn, String publication_year, String genre, Long quantity, Long available){
        super();
        this.book_id = book_id;
        this.book_title = book_title;
        this.author = author;
        this.isbn = isbn;
        this.publication_year = publication_year;
        this.genre = genre;
        this.quantity = quantity;
        this.available = available;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getAvailable() {
        return available;
    }

    public void setAvailable(long available) {
        this.available = available;
    }



    @Override
    public String toString(){
        return "books [id=" + book_id + ", title=" + book_title + ", author=" + author + ", isbn=" + isbn + ", publication_year" + publication_year + ", genre" + genre + ", quantity" + quantity + ", available" + available + "]";
    }
}
