package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;



    /*
    add a user
     */
    @PostMapping(value = "/add")

    public User addUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("emaill") String email, @RequestParam("phone") String phone) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        return userRepository.save(user);
    }

    /*
    select a user based on id
     */
    @GetMapping(value = "/user/{id}")
   public User getUser(@PathVariable("id") Integer id) {
       return userRepository.findById(id).orElse(null);
    }


    @GetMapping(value = "user")
    public List<User> getUserList(){
        return userRepository.findAll();
    }

    /*
    delete a user based on id
     */
    @DeleteMapping(value = "del/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }

    @PutMapping(value = "/user/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("emaill") String email, @RequestParam("phone") String phone)
    {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        return userRepository.save(user);
    }
}