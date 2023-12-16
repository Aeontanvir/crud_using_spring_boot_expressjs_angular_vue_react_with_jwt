package com.aeontanvir.springblogs.controllers;

import com.aeontanvir.springblogs.dtos.PostDto;
import com.aeontanvir.springblogs.responses.ApiResponse;
import com.aeontanvir.springblogs.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostDto>> getById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(ApiResponse.success("Post Details", postService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PostDto>> create(@RequestBody PostDto postDto) throws Exception {
        return ResponseEntity.ok(ApiResponse.success("Post Created", postService.create(postDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PostDto>> update(@RequestBody PostDto postDto, @PathVariable Long id) throws Exception {
        return ResponseEntity.ok(ApiResponse.success("Post Updated", postService.update(postDto, id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) throws Exception {
        postService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Post Deleted", null));
    }

}
