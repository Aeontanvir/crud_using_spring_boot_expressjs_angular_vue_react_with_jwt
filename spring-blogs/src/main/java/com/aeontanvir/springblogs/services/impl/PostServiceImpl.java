package com.aeontanvir.springblogs.services.impl;

import com.aeontanvir.springblogs.dtos.PostDto;
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
        return postRepository.findAll().stream().map(post->modelMapper.map(post, PostDto.class)).toList();
    }

    @Override
    public PostDto getById(Long id) {
        return null;
    }

    @Override
    public PostDto create(PostDto entity) throws Exception {
        return null;
    }

    @Override
    public PostDto update(PostDto req, Long id) throws Exception {
        return null;
    }

    @Override
    public boolean delete(PostDto id) throws Exception {
        return false;
    }
}
