package com.seller.helper.sellerhelper.controller.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    @GetMapping(value = {"", "/keyword"})
    public String index() {
        return "index.html";
    }

    @GetMapping("/margin")
    public String margin() { return "margin.html"; }
}
