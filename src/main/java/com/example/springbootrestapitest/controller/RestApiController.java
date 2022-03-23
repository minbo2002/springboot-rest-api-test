package com.example.springbootrestapitest.controller;

import com.example.springbootrestapitest.dto.PostDto;
import com.example.springbootrestapitest.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class RestApiController {
/*
    @Autowired
    private BoardService boardService;
*/
    private final BoardService boardService;
    // 생성자주입 @Autowired 대신에  --> Service 앞에 final 추가하고 + 클래스명위에 @RequiredArgsConstructor 추가한다.

    @GetMapping("/test")
    public String test() {

        return "test";
    }

    @PostMapping("/create")
    public ResponseEntity<PostDto> create(@RequestBody PostDto postDto) {
        // crtl + Alt + v : 변수 축출
        PostDto newPostDto = boardService.create(postDto);
        // ctrl + p
        return new ResponseEntity<>(newPostDto, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> getAll() {
//        return boardService.getAll();
        return ResponseEntity.ok(boardService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody PostDto postDto, @PathVariable Long id) {
        return ResponseEntity.ok(boardService.update(postDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
            boardService.deleteById(id);
        return ResponseEntity.ok("post 삭제가 완료되었습니다!");
    }
}
