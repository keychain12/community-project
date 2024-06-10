package com.example.soloproject.register.controller;

import com.example.soloproject.member.domain.MemberDTO;
import com.example.soloproject.register.service.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService service;

    @GetMapping("/view.do")
    public String registerViewForm(){


        return "member/register";
    }

    @PostMapping("/view.do")
    public String register(@Valid MemberDTO memberDTO, BindingResult bindingResult, String mm,String dd,
                           Model model) {


        String birthday =  service.birthday(memberDTO.getBirth(), mm, dd); // 생일" yyyy-mm-dd" 형식으로가공
        memberDTO.setBirth(birthday);

        System.out.println(memberDTO.toString());

        service.insertMember(memberDTO);


        return "redirect:/login/view.do";
    }
}
