package com.example.demo.controller;


import com.example.demo.dao.GameRepository;
import com.example.demo.entity.Game;
import com.example.demo.entity.User;


import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller

public class GameInfoController {
         @Autowired
        private GameRepository gameRepository;
        @RequestMapping("/gameinfo")
        public String index() {
            return "gameinfo";
        }

    @RequestMapping(value = "/gameinfo/action")
    @ResponseBody
    public Game action(HttpServletRequest request, @ModelAttribute Game game, Map<String,Object> map){
        try {
            Game games = gameRepository.findByName(game.getName());
            return games;

        } catch(Exception e) {
            return null;
        }


    }
    @RequestMapping(value = "/gameinfo/action1")
    @ResponseBody
    public List<Game> action2(HttpServletRequest request, @ModelAttribute Game game, Map<String,Object> map){
        try {
            List<Game> games = gameRepository.findByType(game.getType());
            return games;

        } catch(Exception e) {
            return null;
        }

    }
//    public String action(@ModelAttribute Game game, Map<String,Object> map){
//        Boolean validator = this.validator(game);
//        if (validator) {
//            Game games = gameRepository.getByName(game.getName());
//            map.put("message","Successful searching, loading...");
//            map.put("games", games);
//            System.out.println("sucesss");
//            return "success";
//
//        }
//        else{
//            map.put("message","Wrong game, please try again");
//            map.put("games","");
//            System.out.println("error");
//            return "error";
//        }
//
//    }
//    private Boolean validator(Game game){
//        String name = game.getName();
//        Game byName = gameRepository.findByName(name);
//        System.out.println("Gamename: "+ name);
//        return name.equals(byName.getName());
//
//    }



}
