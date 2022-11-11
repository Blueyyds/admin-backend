package com.study.homework.service;

import com.study.homework.pojo.R;
import com.study.homework.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface UserService {
    R Login(String username, String password, HttpServletResponse response);

    R Register(String username, String password);

    List<User> getAllUsers();

    User getUserById(long id);

    User getUserByUserName(String username);

    User getInfo(HttpServletRequest request);

    int deleteUser(long id);

    R updateUser(User user);
}
