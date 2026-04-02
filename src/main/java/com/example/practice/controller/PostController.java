package com.example.practice.controller;

import com.example.practice.controller.dto.PostRequest;
import com.example.practice.controller.dto.PostResponse;
import com.example.practice.service.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/api/posts")
    public PostResponse createPost(@RequestBody PostRequest request) {
        PostResponse response = postService.save(request);
        return response;
    }
}
