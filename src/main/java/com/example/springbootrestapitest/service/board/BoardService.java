package com.example.springbootrestapitest.service.board;

import com.example.springbootrestapitest.dto.board.BoardDto;

import java.util.List;

public interface BoardService {

    BoardDto create(BoardDto boardDto);

    List<BoardDto> getAll();

    BoardDto getById(Long id);

    BoardDto update(BoardDto boardDto, Long id);

    void deleteById(Long id);
}
