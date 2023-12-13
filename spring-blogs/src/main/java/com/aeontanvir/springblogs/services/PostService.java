package com.aeontanvir.springblogs.services;

import com.aeontanvir.springblogs.dtos.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<PostDto> getAll();
    PostDto getById(Long id);
    PostDto create(PostDto entity) throws Exception;
    PostDto update(PostDto req, Long id) throws Exception;
    boolean delete(PostDto id) throws Exception;
}
