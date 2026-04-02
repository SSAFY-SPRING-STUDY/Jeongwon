package com.example.practice.service;

import com.example.practice.controller.dto.PostRequest;
import com.example.practice.controller.dto.PostResponse;
import com.example.practice.entity.PostEntity;
import com.example.practice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponse save(PostRequest request) {
        PostEntity entity = PostRequest.toEntity(request);
        PostEntity savedEntity = postRepository.save(entity);
        PostResponse response = PostResponse.fromEntity(savedEntity);
        return response;
    }
}
