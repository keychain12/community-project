package com.example.soloproject.member.repository;

import com.example.soloproject.board.domain.IconDTO;
import com.example.soloproject.member.domain.MemberDTO;
import com.example.soloproject.member.domain.PaymentHistoryDTO;
import com.example.soloproject.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final MemberMapper mapper;
    public List<PaymentHistoryDTO> getPaymentHistory(String user_seq) {
        return mapper.getPaymentHistory(user_seq);
    }

    public void savePoint(Long point, String user_seq) {
        mapper.savePoint(point, user_seq);
    }

    public List<IconDTO> getUserIconList(String user_seq) {
        return mapper.getUserIconList(user_seq);
    }

    public void changeIcon(String pic, String user_seq) {
        mapper.changeIcon(pic, user_seq);
    }

    public MemberDTO getUserBySeq(String user_seq) {
        return mapper.getUserBySeq(user_seq);
    }
}
