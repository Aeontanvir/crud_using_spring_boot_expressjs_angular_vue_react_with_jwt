package com.aeontanvir.springblogs.services.impl;

import com.aeontanvir.springblogs.dtos.PostDto;
import com.aeontanvir.springblogs.models.Comment;
import com.aeontanvir.springblogs.models.Post;
import com.aeontanvir.springblogs.repositories.PostRepository;
import com.aeontanvir.springblogs.services.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<PostDto> getAll() {
        List<PostDto> list = postRepository.findAll().stream().map(post->modelMapper.map(post, PostDto.class)).toList();
        return list;
    }

    @Override
    public PostDto getById(Long id) throws Exception {
        Post post = postRepository.findById(id).orElseThrow(()-> new Exception("Entity Not Found"));
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto create(PostDto entity) throws Exception {
        Post entitPost = Post.builder()
                .title(entity.getTitle())
                .details(entity.getDetails())
                .comments(entity.getComments().stream().map(c->modelMapper.map(c, Comment.class)).toList())
                .build();
        Post post = postRepository.save(entitPost);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto update(PostDto req, Long id) throws Exception {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new Exception("Post not found with id: " + id));
        modelMapper.map(req, existingPost);
        Post updatedPost = postRepository.save(existingPost);
        return modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new Exception("Post not found with id: " + id));
        postRepository.delete(existingPost);
        return !postRepository.existsById(id);
    }
}
