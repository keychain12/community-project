package com.example.soloproject.register.service;

import com.example.soloproject.member.domain.MemberDTO;
import com.example.soloproject.register.repository.RegisterDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterDAO dao;

    public String birthday(String birth, String mm, String dd) { // 생일 형식 메서드

        if (Integer.valueOf(dd) < 10) {
            dd = "0" + dd;
        }
        String birthday = birth + "-" + mm + "-" + dd;


        return birthday;
    }

    public void insertMember(MemberDTO memberDTO) {
        dao.insertMember(memberDTO);
    }
}
