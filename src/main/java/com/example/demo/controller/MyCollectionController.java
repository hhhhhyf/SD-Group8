package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyCollectionController {
    @RequestMapping("/myCollection")
    public String index() {
        return "myCollection";
    }
}
