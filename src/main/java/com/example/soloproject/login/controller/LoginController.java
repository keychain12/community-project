package com.example.soloproject.login.controller;

import com.example.soloproject.login.domain.LoginForm;
import com.example.soloproject.login.service.LoginService;
import com.example.soloproject.member.SessionConst;
import com.example.soloproject.member.domain.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService ;

    @GetMapping("/view.do")
    public String viewForm(){ // 로그인 화면 페이지

        return "member/login";
    }

    @PostMapping("/view.do")
    public String view(@Valid LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request
    , @RequestParam(defaultValue = "/board/view.do") String redirectURL, RedirectAttributes redirectAttributes) { // 로그인 작업
        if (bindingResult.hasErrors()) { // 검증 실패시 뒤돌아가기
            redirectAttributes.addAttribute("errorMessage","아이디 또는 비밀번호가 틀렸습니다.");
            return "redirect:/login/view.do";
        }

        MemberDTO loginMember = loginService.login(loginForm.getEmail(), loginForm.getPw()); // 로그인 회원 점보 담기

        if (loginMember == null) {  // 회원이 없으면 뒤돌아가기
            redirectAttributes.addAttribute("errorMessage","아이디 또는 비밀번호가 틀렸습니다.");
            return "redirect:/login/view.do";
        }
        HttpSession session = request.getSession();  // 세션을 만들어서
        session.setAttribute(SessionConst.LOGIN_MEMBER,loginMember);  // 로그인 객체를 세션에 담자

        return "redirect:" + redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // 클라이언트에 세션을 받아옴, 있으면 기존걸 반환 , 없으면 null을 반환
        if (session != null) {  // 세션에 아이디가 있다면 / 비어있지않다면 세션이
        session.invalidate();  // 세션을 날림
        }
        return "redirect:/board/view.do";
    }


}
