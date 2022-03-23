package com.example.springbootrestapitest.service;

import com.example.springbootrestapitest.dto.PostDto;

import java.util.List;

public interface BoardService {

    PostDto create(PostDto postDto);

    List<PostDto> getAll();

    PostDto getById(Long id);

    PostDto update(PostDto postDto, Long id);

    void deleteById(Long id);
}
