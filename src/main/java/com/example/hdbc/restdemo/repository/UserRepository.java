package com.example.hdbc.restdemo.repository;

import com.example.hdbc.restdemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author:Kevin
 * @version:
 * @Project: restdemo
 * @Package: com.example.hdbc.restdemo.repository
 * @Description:
 * @Date date: 2018/7/30
 */
@Repository
public interface UserRepository extends JpaRepository<User,String>{
}
