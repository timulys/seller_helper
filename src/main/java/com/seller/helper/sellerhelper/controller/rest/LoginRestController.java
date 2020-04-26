package com.seller.helper.sellerhelper.controller.rest;

import com.seller.helper.sellerhelper.dto.MemberDto;
import com.seller.helper.sellerhelper.service.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginRestController {
    private final LoginService loginService;

    @PostMapping("/joinUs/result")
    public String execJoinUs(MemberDto memberDto) {
        loginService.joinUser(memberDto);
        return "redirect:/user/login";
    }
}
