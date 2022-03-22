package com.example.springbootrestapitest.repository;

import com.example.springbootrestapitest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Post, Long> {

}
