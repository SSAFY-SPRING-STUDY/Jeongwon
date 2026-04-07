package com.example.practice.controller.dto;

import com.example.practice.entity.PostEntity;
import lombok.Getter;

@Getter
public class PostResponse {
    public Long id;
    public String title;
    public String content;
    public String author;

    public PostResponse(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public static PostResponse fromEntity(PostEntity entity){
        return new PostResponse(
                entity.getId(), entity.getTitle(), entity.getContent(), entity.getAuthor()
        );
    }


}
