package com.example.practice.repository;

import com.example.practice.entity.PostEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    private static List<PostEntity> postList = new ArrayList<>();

    public PostEntity save(PostEntity entity){
        postList.add(entity);
        return entity;
    }
}
