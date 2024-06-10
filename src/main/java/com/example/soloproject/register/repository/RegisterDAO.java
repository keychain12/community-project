package com.example.soloproject.register.repository;

import com.example.soloproject.member.domain.MemberDTO;
import com.example.soloproject.register.mapper.RegisterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RegisterDAO {
    private final RegisterMapper mapper;


    public void insertMember(MemberDTO memberDTO) {
        mapper.insertMember(memberDTO);
    }
}
