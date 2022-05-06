package com.example.springbootrestapitest.controller.user;

import com.example.springbootrestapitest.dto.user.UserDto;
import com.example.springbootrestapitest.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 회원가입 화면
    @RequestMapping(value = "/signUp/main", method = RequestMethod.GET)
    public ModelAndView signUpMain() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signUp");

        return modelAndView;
    }

    // 회원정보 DB 저장
    @PostMapping(path = "signUp/userData")
    public String signUp(@RequestBody UserDto userDto, Model model) {

        UserDto signUpUserDto = userService.create(userDto);

        model.addAttribute("userId", userDto.getUserId());
        model.addAttribute("name", userDto.getName());
        model.addAttribute("password", userDto.getPassword());
        model.addAttribute("age", userDto.getAge());
        model.addAttribute("address", userDto.getAddress());

        return "signUp";
    }

//    // 회원정보 DB 저장
//    @PostMapping(path = "signUp/userData")
//    public ResponseEntity<UserDto> signUp(@RequestBody UserDto userDto) {
//
//        UserDto signUpUserDto = userService.create(userDto);
//
//        return new ResponseEntity<>(signUpUserDto, HttpStatus.CREATED);
//    }
}
