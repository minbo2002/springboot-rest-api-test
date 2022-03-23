package com.example.springbootrestapitest.service;

import com.example.springbootrestapitest.dto.PostDto;
import com.example.springbootrestapitest.entity.Post;
import com.example.springbootrestapitest.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public PostDto create(PostDto postDto) {

        // dto -> entity
        Post post = mapToEntity(postDto);

        Post save = boardRepository.save(post);   // DB에 저장

        // entity -> dto
        PostDto newPostDto = mapToDto(save);
        // return
        return newPostDto;
    }

    @Override
    public List<PostDto> getAll() {
//        return boardRepository.findAll();
        List<Post> posts = boardRepository.findAll();
        return posts.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    // refactoring, ctrl + Alt + M : 메서드 축출
    private PostDto mapToDto(Post save) {
        PostDto newPostDto = new PostDto();
        newPostDto.setTitle(save.getTitle());
        newPostDto.setContent(save.getContent());
        return newPostDto;
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        return post;
    }
}
