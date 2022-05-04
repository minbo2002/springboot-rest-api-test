package com.example.springbootrestapitest.controller.user;

import com.example.springbootrestapitest.dto.user.UserDto;
import com.example.springbootrestapitest.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;

    @GetMapping(path = "signUp/main")
    public ModelAndView signUpMain() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signUp");

        return modelAndView;
    }

    @PostMapping(path = "signUp/userData")
    public ResponseEntity<UserDto> signUp(@RequestBody UserDto userDto) {

        UserDto signUpUserDto = userService.create(userDto);

        return new ResponseEntity<>(signUpUserDto, HttpStatus.CREATED);
    }
}
