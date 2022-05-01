package com.example.springbootrestapitest.dto.user;

import lombok.Data;

@Data
public class UserDto {

    private String userId;
    private String name;
    private int age;
    private String address;
}
