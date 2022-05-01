package com.example.springbootrestapitest.service.board;

import com.example.springbootrestapitest.dto.board.BoardDto;
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
    public BoardDto create(BoardDto boardDto) {

        // dto -> entity
        Board board = mapToEntity(boardDto);

        // DB 저장
        Board save = boardRepository.save(board);

        // entity -> dto
        BoardDto newBoardDto = mapToDto(save);

        return newBoardDto;
    }

    @Override
    public List<BoardDto> getAll() {

        List<Board> posts = boardRepository.findAll();
        return posts.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BoardDto getById(Long id) {
        Board post = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post", "postId"));
        return mapToDto(post);
    }

    @Override
    public BoardDto update(BoardDto boardDto, Long id) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post", "postId"));

        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());

        return mapToDto(boardRepository.save(board));
    }

    @Override
    public void deleteById(Long id) {
        Board post = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post", "postId"));
        boardRepository.delete(post);
    }

    private Board updateEntity(BoardDto boardDto) {

        return Board.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .build();
    }

    private BoardDto mapToDto(Board save) {
        BoardDto newBoardDto = new BoardDto();
        newBoardDto.setTitle(save.getTitle());
        newBoardDto.setContent(save.getContent());
        return newBoardDto;
    }

    private Board mapToEntity(BoardDto boardDto) {
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        return board;
    }
}
