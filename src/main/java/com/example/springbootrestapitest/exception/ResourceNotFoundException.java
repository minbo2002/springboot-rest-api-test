package com.example.springbootrestapitest.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private final String resourceName;
    private final String fieldName;

    public ResourceNotFoundException(String resourceName, String fieldName) {
        super(String.format("%s not found with %s", resourceName, fieldName)); // Post not found with postId
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }

}
