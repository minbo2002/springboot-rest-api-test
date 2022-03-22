package com.example.springbootrestapitest.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;  // 뭔지 알아보기
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RestApiController {

    @GetMapping("/")
    public String test() {

        return "test";
    }
}
