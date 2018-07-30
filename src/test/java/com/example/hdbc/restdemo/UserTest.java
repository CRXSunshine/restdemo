package com.example.hdbc.restdemo;

import com.example.hdbc.restdemo.domain.User;
import com.example.hdbc.restdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author:Kevin
 * @version:
 * @Project: restdemo
 * @Package: com.example.hdbc.restdemo
 * @Description:
 * @Date date: 2018/7/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private MockMvc mockMvc;
    private UserService userService=new UserService();
    @Test
    public void saveUser(){
        User user=new User();
        user.setId("20150611");
        user.setUsername("kevin");
        user.setPassword("123456");
        User user1=userService.saveUser(user);
        System.out.println(user1);
    }
}
