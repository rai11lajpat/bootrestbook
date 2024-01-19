package com.api.book.bootrestbook.entities_models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;
    private String firstName;
    private String lastName;
    private String language;

    //should not create book table in author
    @OneToOne(mappedBy = "author")

    // to avoid recursion
    @JsonBackReference
    private Book book;

    @Override
    public String toString() {
        return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", language="
                + language + "]";
    }

    public Author() {
    }

    public Author(int authorId, String firstName, String lastName, String language) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
