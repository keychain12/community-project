package com.example.soloproject.board;

import lombok.Data;

@Data
public class FileResponse {
    private String originalFileName;
    private String url;
    private String board_seq;
    public FileResponse(String originalFileName, String url) {
        this.originalFileName = originalFileName;
        this.url = url;
    }

    public FileResponse(String originalFileName, String url,String board_seq) {
        this.originalFileName = originalFileName;
        this.url = url;
        this.board_seq = board_seq;
    }
}
