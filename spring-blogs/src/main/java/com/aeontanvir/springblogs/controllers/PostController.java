package com.aeontanvir.springblogs.controllers;

import com.aeontanvir.springblogs.dtos.PostDto;
import com.aeontanvir.springblogs.responses.ApiResponse;
import com.aeontanvir.springblogs.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<PostDto>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("All Post List", postService.getAll()));
    }

}
