package com.spacetravel.spring_15.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Note {

    @Id
    private Long id;
    private String title;
    private String content;

    // Гетери та сетери

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
