package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
@Data

public class User implements Serializable {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="usr_id")
     private Integer id;
     @Column(name="usr_name")
     private String username;
     @Column(name="usr_pwd")
     private String password;
     @Column(name="usr_email")
     private String email;
     @Column(name="usr_phone")
     private String phone;
    public User(){
    }



}