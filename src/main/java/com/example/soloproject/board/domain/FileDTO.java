package com.example.soloproject.board.domain;

import lombok.Data;

@Data
public class FileDTO {
    private int id;
    private int board_seq;
    private String stored_name;
    private String original_name;
    private String file_type;
}
