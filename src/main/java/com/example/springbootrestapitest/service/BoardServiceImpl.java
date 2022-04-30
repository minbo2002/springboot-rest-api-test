package com.example.springbootrestapitest.service;

import com.example.springbootrestapitest.dto.PostDto;
import com.example.springbootrestapitest.entity.Board;
import com.example.springbootrestapitest.exception.ResourceNotFoundException;
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
        Board post = mapToEntity(postDto);

        Board save = boardRepository.save(post);   // DB에 저장

        // entity -> dto
        PostDto newPostDto = mapToDto(save);
        // return
        return newPostDto;
    }

    @Override
    public List<PostDto> getAll() {
//        return boardRepository.findAll();
        List<Board> posts = boardRepository.findAll();
        return posts.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getById(Long id) {
        Board post = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post", "postId"));
        return mapToDto(post);
    }

    @Override
    public PostDto update(PostDto postDto, Long id) {

        Board post = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post", "postId"));

//        post = updateEntity(postDto);
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        return mapToDto(boardRepository.save(post));
    }

    @Override
    public void deleteById(Long id) {
        Board post = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post", "postId"));
        boardRepository.delete(post);
    }

    private Board updateEntity(PostDto postDto) {

        return Board.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .build();
    }


    // refactoring, ctrl + Alt + M : 메서드 축출
    private PostDto mapToDto(Board save) {
        PostDto newPostDto = new PostDto();
        newPostDto.setTitle(save.getTitle());
        newPostDto.setContent(save.getContent());
        return newPostDto;
    }

    private Board mapToEntity(PostDto postDto) {
        Board post = new Board();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        return post;
    }
}
