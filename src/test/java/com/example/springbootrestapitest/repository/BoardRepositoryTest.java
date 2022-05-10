package com.example.springbootrestapitest.repository;

import com.example.springbootrestapitest.entity.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    private Board board;

    @BeforeEach
    void setup() {
        board = Board.builder()
                .title("test_title")
                .content("test_content")
                .build();
    }

    @Test
    void create() {
        // given
        Board saveBoard = boardRepository.save(board);

        // when
        // then
        assertThat(saveBoard.getTitle()).isEqualTo("test_title");
    }
}