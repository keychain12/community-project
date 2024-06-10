package com.example.soloproject.web;

import com.example.soloproject.web.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor()) // 로그인 필터
                .order(1)
                .addPathPatterns("/board/create","/board/comment/write","/board/item/buy","/member/payment-history","/member/buy-points"
                , "/member/payment-page","/member/info","/member/iconsetting","/board/edit");
                // 로그인해야 가능한곳 지정해주기
    }



}
