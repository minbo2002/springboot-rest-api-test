package com.example.springbootrestapitest.service;

import com.example.springbootrestapitest.dto.PostDto;
import com.example.springbootrestapitest.entity.Post;
import com.example.springbootrestapitest.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public PostDto create(PostDto postDto) {

        // dto -> entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        Post save = boardRepository.save(post);   // DB에 저장

        // entity -> dto
        PostDto postDto1 = new PostDto();
        postDto1.setTitle(save.getTitle());
        postDto1.setContent(save.getContent());

        // return
        return postDto1;
    }
}
