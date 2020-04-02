package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Game")
@Data

public class Game implements Serializable {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="game_id")
     private Integer id;
     @Column(name="game_name")
     private String name;
     @Column(name="game_date")
     private String date;
     @Column(name="game_price")
     private String price;
     @Column(name="game_likes")
     private Integer likes;
     @Column(name="game_rate")
     private Integer rate;
     @Column(name="game_type")
     private String type;
     @Column(name="game_avai")
     private String availability;
     @Column(name="game_ESRB")
     private String ESRB;
     @Column(name="game_image")
     private String image;
     @Column(name="game_plat")
     private String platform;
    public Game(){
    }



}