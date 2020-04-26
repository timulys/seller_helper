package com.seller.helper.sellerhelper.controller.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LoginViewController {

    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "/index";
    }

    // 회원가입 페이지
    @GetMapping("/user/joinus")
    public String joinUs() {
        return "/login/joinus";
    }

}
