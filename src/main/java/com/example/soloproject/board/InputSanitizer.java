package com.example.soloproject.board;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.stereotype.Component;

@Component
public class InputSanitizer {  // xss 방지 외부 라이브러리
    public static String sanitize(String input) {
        return Jsoup.clean(input, Whitelist.none());
    }
}
