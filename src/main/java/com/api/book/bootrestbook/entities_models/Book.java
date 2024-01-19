package com.api.book.bootrestbook.entities_models;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    private int id;

    private String bookName;

    @OneToOne(cascade = CascadeType.ALL)

    // to avoid recursion
    @JsonManagedReference
    private Author author;

    
    @Override
    public String toString() {
        return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + "]";
    }

    public Book() {
    }

    public Book(int id, String bookName, Author author) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    
}
