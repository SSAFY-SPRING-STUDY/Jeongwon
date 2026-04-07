package com.example.practice.controller;

import com.example.practice.controller.dto.PostRequest;
import com.example.practice.controller.dto.PostResponse;
import com.example.practice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jmx.ParentAwareNamingStrategy;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    private final ParentAwareNamingStrategy parentAwareNamingStrategy;

    @Autowired
    public PostController(PostService postService, ParentAwareNamingStrategy parentAwareNamingStrategy) {
        this.postService = postService;
        this.parentAwareNamingStrategy = parentAwareNamingStrategy;
    }


    // 1. 게시글 등록 (주문서(@RequestBody)를 받아서 Service에 넘긴다)
    @PostMapping()
    public PostResponse createPost(@RequestBody PostRequest request) {
        PostResponse response = postService.save(request);
        return response;
    }

    // 2. 전체 목록 조회
    @GetMapping()
    public List<PostResponse> findAllPosts(){
        return postService.findAll(); // service에 있던 responseList를 반환
    }


    // 3. 특정 게시글 상세 조회
    @GetMapping("{id}")
    public PostResponse findPostById(@PathVariable Long id){
        PostResponse response = null;
        try{
            response = postService.findById(id);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
       return response;

    }


    // 4. 특정 ID의 게시글 수정 요청 처리 update
    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequest request){
        postService.update(id, request);
    }


    // 5. 게시글 삭제
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.delete(id);
    }
}
