package com.example.soloproject.login.mapper;

import com.example.soloproject.member.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.lang.reflect.Member;

@Mapper
public interface LoginMapper {


    MemberDTO login(String email, String pw);

}
