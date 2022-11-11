package com.study.homework.dao;

import com.study.homework.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void testGetUser(){
        System.out.println(userDao.getUserById(2));
    }
}
