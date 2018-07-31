package com.example.hdbc.restdemo.controller;

import com.example.hdbc.restdemo.common.utils.ResponseResults;
import com.example.hdbc.restdemo.domain.User;
import com.example.hdbc.restdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:Kevin
 * @version:
 * @Project: restdemo
 * @Package: com.example.hdbc.restdemo.controller
 * @Description: UserController
 * @Date date: 2018/7/30
 */
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * saveUser
     * @param user
     * @return User
     */
    @PostMapping("/user")
    public ResponseResults saveUser(@RequestBody User user){
        return ResponseResults.responseBySuccess("ok",userService.saveUser(user));
    }

    /**
     * updateUser
     * @param user
     * @return User
     */
    @PutMapping("/user")
    public ResponseResults updateUser(@RequestBody  User  user){
        return ResponseResults.responseBySuccess("ok",userService.updateUser(user));
    }

    /**
     * deleteUserById
     * @param id
     * @return String
     */
    @DeleteMapping("user/{id}")
    public ResponseResults deleteUserById(@PathVariable String  id){
        return ResponseResults.responseBySuccess("ok",userService.deleteUserById(id));
    }

    /**
     * queryUserById
     * @param id
     * @return User
     */
    @GetMapping("user/{id}")
    public ResponseResults queryUserById(@PathVariable String id){
        return ResponseResults.responseBySuccess("ok",userService.getUserById(id));
    }

    @GetMapping("user")
    public ResponseResults getUserList(){
        return ResponseResults.responseBySuccess("ok",userService.getUserList());
    }



}
