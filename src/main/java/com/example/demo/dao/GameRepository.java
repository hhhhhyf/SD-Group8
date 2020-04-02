package com.example.demo.dao;

import com.example.demo.entity.Game;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Integer> {
     Game findByName(String name);
     List<Game> findByESRB(String ESRB);
     List<Game> findByType(String type);

}
