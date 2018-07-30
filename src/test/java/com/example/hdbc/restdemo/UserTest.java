package com.example.hdbc.restdemo;

import com.alibaba.fastjson.JSON;
import com.example.hdbc.restdemo.domain.User;
import com.example.hdbc.restdemo.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.nio.cs.Surrogate.is;

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
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();  //构造MockMvc

    }

    @Test
    public void saveUser(){
        User user=new User();
        user.setId("20150611");
        user.setUsername("头号玩家");
        user.setPassword("123456");
        String json=JSON.toJSONString(user);
        try {
            mockMvc.perform(post("/user")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .param(json)
                    .accept(MediaType.APPLICATION_JSON))  //接收的类型
                    .andExpect(status().isOk())   //判断接收到的状态是否是200
                    .andDo(print())  //打印内容
                    .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect((ResultMatcher) content().string(Matchers.containsString("OK"))); //匹配返回值中的内容
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setId("20150611");
        user.setUsername("奇点");
        user.setPassword("123456");
        String json=JSON.toJSONString(user);
        try {
            mockMvc.perform(put("/user")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .param(json)
                    .accept(MediaType.APPLICATION_JSON))  //接收的类型
                    .andExpect(status().isOk())   //判断接收到的状态是否是200
                    .andDo(print())  //打印内容
                    .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect((ResultMatcher) content().string(Matchers.containsString("OK"))); //匹配返回值中的内容
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    @Test
    public void queryByUserId() {
        String id="20150611";
        try {
            mockMvc.perform(put("/user")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .param(id)
                    .accept(MediaType.APPLICATION_JSON))  //接收的类型
                    .andExpect(status().isOk())   //判断接收到的状态是否是200
                    .andDo(print())  //打印内容
                    .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect((ResultMatcher) content().string(Matchers.containsString("OK"))); //匹配返回值中的内容
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteByUserId() {
        String id="20150611";
        try {
            mockMvc.perform(delete("/user")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .param(id)
                    .accept(MediaType.APPLICATION_JSON))  //接收的类型
                    .andExpect(status().isOk())   //判断接收到的状态是否是200
                    .andDo(print())  //打印内容
                    .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect((ResultMatcher) content().string(Matchers.containsString("OK"))); //匹配返回值中的内容
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
