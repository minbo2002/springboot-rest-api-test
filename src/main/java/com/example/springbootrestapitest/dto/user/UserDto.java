package com.example.springbootrestapitest.dto.user;

import lombok.Data;

@Data
public class UserDto {

    private Long userId;
    private String password;
    private String name;
    private int age;
    private String address;
}
