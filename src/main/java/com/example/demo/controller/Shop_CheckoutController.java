package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class Shop_CheckoutController {

        @RequestMapping("/shop-checkout")
        public String index() {
            return "shop-checkout";
        }



}
