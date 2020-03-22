package com.clover.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("hello")
public class HelloWorldController {

    @RequestMapping("showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("processFormV2")
    public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {
        theName = theName.toUpperCase();

        String result = "Yo! " + theName;

        model.addAttribute("message", result);

        return "helloworld";
    }
}
