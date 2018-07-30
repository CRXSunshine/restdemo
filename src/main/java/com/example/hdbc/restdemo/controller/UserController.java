package com.example.hdbc.restdemo.controller;

import com.example.hdbc.restdemo.domain.User;
import com.example.hdbc.restdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:Kevin
 * @version:
 * @Project: restdemo
 * @Package: com.example.hdbc.restdemo.controller
 * @Description:
 * @Date date: 2018/7/30
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name){
        return "hello"+name;
    }
    /**
     * saveUser
     * @param user
     * @return User
     */
    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    /**
     * updateUser
     * @param user
     * @return User
     */
    @PutMapping("/user")
    public User updateUser(@RequestBody  User  user){
        return userService.updateUser(user);
    }

    /**
     * deleteUserById
     * @param id
     * @return String
     */
    @DeleteMapping("user/{id}")
    public String deleteUserById(@PathVariable String  id){
        return userService.deleteUserById(id);
    }

    /**
     * queryUserById
     * @param id
     * @return User
     */
    @GetMapping("user/{id}")
    public User queryUserById(@PathVariable String id){
        return userService.getUserById(id);
    }



}
