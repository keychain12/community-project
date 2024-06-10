package com.example.soloproject.login.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm {

//    @NotEmpty(message = "아이디를 입력해주세요.")
    private String email;
//    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String pw;
}
