package com.example.soloproject.board.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class BoardForm {

    private String board_seq;
    private String user_seq; // 작성자
    @NotEmpty(message = "제목을 입력해주세요.")
    private String title;  // 제목
    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;  // 컨텐츠
    private MultipartFile attachment; // 첨부파일
    private List<MultipartFile> imageFiles; // 여러개 첨부파일
    private String table_type;
}
