package com.example.soloproject.register.mapper;

import com.example.soloproject.member.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
    void insertMember(MemberDTO memberDTO);
}
