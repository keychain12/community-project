package com.example.soloproject.member.service;

import com.example.soloproject.board.domain.IconDTO;
import com.example.soloproject.member.domain.MemberDTO;
import com.example.soloproject.member.domain.PaymentHistoryDTO;
import com.example.soloproject.member.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.soloproject.member.SessionConst.LOGIN_MEMBER;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

//    결제 내역 가져오기
    public List<PaymentHistoryDTO> getPaymentHistory(String user_seq) {
        return repository.getPaymentHistory(user_seq);
    }


    public void savePoint(Long point, String user_seq) {



        repository.savePoint(point, user_seq);
    }

    public List<IconDTO> getUserIconList(String user_seq) {
        return repository.getUserIconList(user_seq);
    }

    public void changeIcon(String pic, String user_seq, HttpServletRequest request) {
       // 아이콘저장
        repository.changeIcon(pic, user_seq);
      // 아이콘 바로적용
        HttpSession session = request.getSession();
       MemberDTO member =  repository.getUserBySeq(user_seq);
        session.setAttribute(LOGIN_MEMBER, member);


    }

    public MemberDTO getUserBySeq(String user_seq) {
        return repository.getUserBySeq(user_seq);
    }
}
