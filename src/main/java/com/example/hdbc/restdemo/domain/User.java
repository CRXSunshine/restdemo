package com.example.hdbc.restdemo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author:Kevin
 * @version:
 * @Project: restdemo
 * @Package: com.example.hdbc.restdemo.domain
 * @Description:
 * @Date date: 2018/7/30
 */
@Entity
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String password;

}
