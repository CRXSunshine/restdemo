package com.example.hdbc.restdemo.service;

import com.example.hdbc.restdemo.domain.User;
import com.example.hdbc.restdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Kevin
 * @version:
 * @Project: restdemo
 * @Package: com.example.hdbc.restdemo.service
 * @Description:
 * @Date date: 2018/7/30
 */
@Service("userService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
       return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.saveAndFlush(user);
    }

    public String deleteUserById(String id){
        userRepository.deleteById(id);
        return "删除成功";
    }

    public User getUserById(String id){
        return userRepository.findById(id).get();
    }

    public List<User> getUserList(){
        return userRepository.findAll();
    }

}
