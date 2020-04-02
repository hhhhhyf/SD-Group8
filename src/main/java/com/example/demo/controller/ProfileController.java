package com.example.demo.controller;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String index() {
        return "profile";
    }
}