package com.example.demo.controller;


import com.example.demo.dao.GameRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Game;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller

public class FindPlayerController {
    @Autowired
    private UserRepository userRepository;
        @RequestMapping("/findPlayer")
        public String index() {
            return "findPlayer";
        }

    @RequestMapping(value = "/findPlayer/action")
    @ResponseBody
    public User action(HttpServletRequest request, @ModelAttribute User user, Map<String,Object> map){
        try {
            System.out.println(user.getUsername());
            User users = userRepository.findByUsername(user.getUsername());
            return users;

        } catch(Exception e) {
            return null;
        }


    }

}
