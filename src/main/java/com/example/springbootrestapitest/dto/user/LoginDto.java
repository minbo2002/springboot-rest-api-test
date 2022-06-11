package com.example.springbootrestapitest.dto.user;

import lombok.Data;

@Data
public class LoginDto {

    private String name;
    private String password;
}