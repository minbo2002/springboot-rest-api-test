package com.example.springbootrestapitest.controller;

import com.example.springbootrestapitest.dto.PostDto;
import com.example.springbootrestapitest.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;  // 뭔지 알아보기
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
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
}
