package com.example.soloproject.board.domain;

import lombok.Data;

@Data
public class CommentDTO {
    private String comment_seq;
    private String board_seq;
    private String user_seq;
    private String name;
    private String regdate;
    private String content;
    private String pic;
    private int likes;
    private int dislikes;
}

   /* comment_seq number primary key not null ,
        board_seq number,
        FOREIGN KEY (board_seq) references BOARDTWO(seq),
        author varchar2(50) not null ,
        regdate date default sysdate not null ,
        content clob,
        likes number default 0,
        dislikes number default 0*/