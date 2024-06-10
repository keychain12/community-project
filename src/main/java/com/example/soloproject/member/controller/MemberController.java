package com.example.soloproject.member.controller;

import com.example.soloproject.board.domain.IconDTO;
import com.example.soloproject.member.SessionConst;
import com.example.soloproject.member.domain.MemberDTO;
import com.example.soloproject.member.domain.PaymentHistoryDTO;
import com.example.soloproject.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;

import static com.example.soloproject.member.SessionConst.LOGIN_MEMBER;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService service;

    @GetMapping("/payment-history") //결제내역 페이지
    public String paymentHistory(HttpServletRequest request, Model model) {

        // 로그인 세션가져오기
        HttpSession session = request.getSession();
        MemberDTO loginMember = (MemberDTO) session.getAttribute(LOGIN_MEMBER);

        // 해당유저의 결제내역 가져오기
        List<PaymentHistoryDTO> paymentHistory = service.getPaymentHistory(loginMember.getUser_seq());


        model.addAttribute("paymentHistory", paymentHistory);
        return "member/history";
    }

    @GetMapping("/buy-points") // 포인트 구매페이지
    public String buyPointsForm() {


        return "member/buy";
    }

    @GetMapping("/payment-page") // 결제페이지
    public String page(String point, Model model) {


        model.addAttribute("point", point);
        return "member/paymentpage";
    }

    @PostMapping("/buy-points") // 포인트 구매
    public String buyPoints(Long point, HttpServletRequest request) {

        // 로그인 세션가져오기
        HttpSession session = request.getSession();
        MemberDTO loginMember = (MemberDTO) session.getAttribute(LOGIN_MEMBER);


        //유저 포인트 디비에 저장
        service.savePoint(point, loginMember.getUser_seq());
        MemberDTO member = service.getUserBySeq(loginMember.getUser_seq());
        session.setAttribute(LOGIN_MEMBER, member);

        return "redirect:/board/view.do";
    }


    @GetMapping("/info")
    public String userInfo(HttpServletRequest request, Model model) {
        //로그인 세션 가져오기
        HttpSession session = request.getSession();
        MemberDTO loginMember = (MemberDTO) session.getAttribute(LOGIN_MEMBER);


        model.addAttribute("dto", loginMember);
        return "member/info";
    }

    @GetMapping("/iconsetting")
    public String iconSetting(Model model, HttpServletRequest request) {

        //로그인 세션 가져오기
        HttpSession session = request.getSession();
        MemberDTO loginMember = (MemberDTO) session.getAttribute(LOGIN_MEMBER);

        //회원이 구매한 아이콘 정보가져오기
        List<IconDTO> list = service.getUserIconList(loginMember.getUser_seq());


        model.addAttribute("list", list);
        return "member/iconsetting";
    }

    @PostMapping("/changeIcon")
    public String changeIcon(String pic, HttpServletRequest request) {

        HttpSession session = request.getSession();
        MemberDTO loginMember = (MemberDTO) session.getAttribute(LOGIN_MEMBER);


        // 아이콘 바꾸기
        service.changeIcon(pic, loginMember.getUser_seq(),request);

        return "redirect:/member/iconsetting";
    }

}
