package com.example.practice.controller.dto;

import com.example.practice.entity.PostEntity;
import lombok.Getter;

@Getter
public class PostRequest {
    private final String title;
    private final String content;
    private final String author;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public PostRequest(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public static PostEntity toEntity(PostRequest request){
        return new PostEntity(
                request.title, request.content, request.author
        );
    }
}
