package com.example.practice.service;

import com.example.practice.controller.dto.PostRequest;
import com.example.practice.controller.dto.PostResponse;
import com.example.practice.entity.PostEntity;
import com.example.practice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public PostResponse save(PostRequest request) {
        PostEntity entity = PostRequest.toEntity(request); // 1. service가 request를 보고 2. Entity에 옮겨 담아 toEntity
        PostEntity savedEntity = postRepository.save(entity); // 3. Entity를 repository에 보내서 영구 보관을해
        PostResponse response = PostResponse.fromEntity(savedEntity); // 4. 그리고 손님한테는 response에 담아줘
        return response;
    }

    public List<PostResponse> findAll() {
        List<PostEntity> entityList = postRepository.findAll();
        List<PostResponse> responseList = new ArrayList<>();

        for(PostEntity entity : entityList){ // response로 변환하는 작업
            PostResponse response = PostResponse.fromEntity(entity);
            responseList.add(response);
        }
        return responseList; // responseList를 controller에 넘겨주고
    }

    public PostResponse findById(Long id) {
        PostEntity foundEntity = postRepository.findById(id).orElseThrow(()-> new RuntimeException("ID값에 맞는 게시글이 존재하지 않습니다."));
        PostResponse response = PostResponse.fromEntity(foundEntity);

        return response;
    }

    public void update(Long id, PostRequest request) {
        postRepository.update(id,request);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
