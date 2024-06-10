package com.example.soloproject.board.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PopularPostDTO {
    private Long id;
    private Long board_seq;
    private LocalDateTime createdAt;
}
