package com.example.soloproject.login.repository;

import com.example.soloproject.login.mapper.LoginMapper;
import com.example.soloproject.member.domain.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoginDAO {

    private final LoginMapper mapper;


    public MemberDTO login(String email, String pw) {
        return mapper.login(email, pw);
    }
}
