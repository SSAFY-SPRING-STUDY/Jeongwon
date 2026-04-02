package com.example.practice.entity;

import lombok.Getter;

@Getter
public class PostEntity {
    private static Long AUTO_INCREMENT = 1L;

    private Long id;
    private String title;
    private String content;
    private String author;


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public PostEntity(String title, String content, String author) {
        this.id = AUTO_INCREMENT++;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
