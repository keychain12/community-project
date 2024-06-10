package com.example.soloproject.login.service;

import com.example.soloproject.login.repository.LoginDAO;
import com.example.soloproject.member.domain.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginDAO dao;

    public MemberDTO login(String email, String pw) {
        return dao.login(email,pw);
    }

}
