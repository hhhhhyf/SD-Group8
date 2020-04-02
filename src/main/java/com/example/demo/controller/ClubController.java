package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class ClubController {

    @RequestMapping("/club")
    public String index() {
        return "club";
    }



}
