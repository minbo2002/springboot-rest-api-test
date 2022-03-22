package com.example.springbootrestapitest.controller;

import com.example.springbootrestapitest.dto.PostDto;
import com.example.springbootrestapitest.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;  // 뭔지 알아보기
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RestApiController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String test() {

        return "test";
    }

    @PostMapping("/create")
    public PostDto create(@RequestBody PostDto postDto) {
        // crtl + Alt + v : 변수 축출
        PostDto postDto1 = boardService.create(postDto);

        return postDto1;
    }
}
