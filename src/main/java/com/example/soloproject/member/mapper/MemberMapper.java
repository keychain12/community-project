package com.example.soloproject.member.mapper;

import com.example.soloproject.board.domain.IconDTO;
import com.example.soloproject.member.domain.MemberDTO;
import com.example.soloproject.member.domain.PaymentHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {


    List<PaymentHistoryDTO> getPaymentHistory(String user_seq);

    void savePoint(Long point, String user_seq);

    List<IconDTO> getUserIconList(String user_seq);

    void changeIcon(String pic, String user_seq);

    MemberDTO getUserBySeq(String user_seq);
}
