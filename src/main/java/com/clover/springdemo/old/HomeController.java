package com.clover.springdemo.old;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

    @RequestMapping("/")
    public String showMyPage() {
        return "main-menu";
    }
}
