package com.study.homework.service;

import com.study.homework.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void UserServiceTest(){
        System.out.println(userService.getUserById(1));
    }
}
