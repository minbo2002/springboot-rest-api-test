package com.example.springbootrestapitest.controller.board;

import com.example.springbootrestapitest.dto.board.BoardDto;
import com.example.springbootrestapitest.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardService boardService;


    @GetMapping("/test")
    public String test() {

        System.out.println("PR test");
        return "test";
    }

    @PostMapping("/create")
    public ResponseEntity<BoardDto> create(@RequestBody BoardDto boardDto) {

        BoardDto newBoardDto = boardService.create(boardDto);

        return new ResponseEntity<>(newBoardDto, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BoardDto>> getAll() {

        return ResponseEntity.ok(boardService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BoardDto> getById(@PathVariable Long id) {

        return ResponseEntity.ok(boardService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody BoardDto boardDto, @PathVariable Long id) {

        return ResponseEntity.ok(boardService.update(boardDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
            boardService.deleteById(id);

        return ResponseEntity.ok("board 삭제가 완료되었습니다!");
    }
}
