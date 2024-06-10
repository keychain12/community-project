package com.example.soloproject.member.domain;

import com.example.soloproject.board.domain.IconDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class MemberDTO {

    private String user_seq;
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-_=+{};:,<.>/?]).{8,16}$" , message = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String pw;
    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;
    @NotEmpty(message = "생년월일을 입력해주세요.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "올바른 생일 형식(YYYY-MM-DD)으로 입력해주세요.")
    private String birth;
    @NotEmpty(message = "이메일주소를 입력해주세요.")
    @Email(message = "올바른 이메일주소를 입력해주세.")
    private String email;
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$", message = "올바른 전화번호 형식(010-1234-5678)으로 입력해주세요.")
    private String tel;
    @NotEmpty(message = "고등학교를 입력해주세요.")
    private String high_school;
    private Integer money;
    private String lv;
    private String pic;
    private String ing;
    private List<IconDTO> iconlist;

}

