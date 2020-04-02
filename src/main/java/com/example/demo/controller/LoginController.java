package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.util.Map;

@Controller

public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index(@ModelAttribute User user){
        return "login";
    }

    @RequestMapping(value = "/login/action")
    @ResponseBody
    public String action(HttpServletRequest request, @ModelAttribute User user, Map<String,Object> map){
        Boolean validator = this.validator(user);
        if (validator) {
            HttpSession session = request.getSession();
            session.setAttribute("user",user.getUsername());
            map.put("message","Successful login, loading...");
            map.put("url","/");
            System.out.println("sucesss");
            return "success";
        }
        else{
            map.put("message","Wrong account, please try again");
            map.put("url","/login");
            System.out.println("error");
            return "error";
        }

    }

    private Boolean validator(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        User byUsername = userRepository.findByUsername(username);
        System.out.println("Username:"+username+" Password:"+password);
        System.out.println(byUsername.getPassword());
        return password.equals(byUsername.getPassword());

    }


}
