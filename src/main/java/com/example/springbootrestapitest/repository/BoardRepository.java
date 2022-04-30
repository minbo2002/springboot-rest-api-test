package com.example.springbootrestapitest.repository;

import com.example.springbootrestapitest.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {

}
