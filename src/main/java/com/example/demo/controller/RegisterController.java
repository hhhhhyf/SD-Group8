package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/register")
    public String index(){
        return "register";
    }

    @RequestMapping(value = "/register/action")
    @ResponseBody
    public String action(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("email") String email, @RequestParam("phone") String phone, Map<String,Object> map){
        System.out.println("Username: "+username+" "+"Password: "+password);
        User findUser = userRepository.findByUsername(username);
        if(findUser != null){
            map.put("message","duplicate username");
            map.put("url","register");
            return "exist";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        userRepository.save(user);
        System.out.println("Successfully insert into database");
        map.put("message","successfully registed");
        map.put("url","/login");
        return "success";

    }
}
