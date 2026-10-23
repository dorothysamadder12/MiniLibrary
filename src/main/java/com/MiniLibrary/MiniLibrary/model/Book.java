
package com.MiniLibrary.MiniLibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String googleBooksId;
    private String title;
    private String authors;
    private String description;
    private String thumbnail;
    private String category;
    private String status = "WANT_TO_READ";

    public Book() {
    }

    public Book(String googleBooksId, String title, String authors,
                String description, String thumbnail, String category) {
        this.googleBooksId = googleBooksId;
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getGoogleBooksId() {
        return googleBooksId;
    }

    public void setGoogleBooksId(String googleBooksId) {
        this.googleBooksId = googleBooksId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

}
