package com.example.soloproject.board;

import lombok.Data;

@Data
public class UploadFile {

    private String board_seq;

    private String original_name;  // 고객이 올린 원래 파일이름

    private String stored_name; //  저장할 변경된 파일이름

    private String file_type;
    public UploadFile(String uploadFileName, String storeFileName) {
        this.original_name = uploadFileName;
        this.stored_name = storeFileName;
    }



}
