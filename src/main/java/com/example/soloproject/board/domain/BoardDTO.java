package com.example.soloproject.board.domain;

import com.example.soloproject.board.UploadFile;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class BoardDTO {

    private String board_seq; //번호
    @NotEmpty(message = "제목을 입력해주세요.")
    private String title;  // 제목
    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;  // 컨텐츠
    private String user_seq; // 작성자 번호
    private String name; // 작성자이름
    private String regdate; // 작성일
    private int views; // 조회수
    private UploadFile attachment; // 첨부파일
    private int likes; //좋아요
    private int dislikes; //싫어요
    private String table_type; // 게시판타입
    private int totalLikes; //좋아요 - 싫어요수
    private List<UploadFile> imageFiles; // 여러개 첨부파일




}

