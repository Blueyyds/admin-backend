package com.study.homework.service.impl;

import com.study.homework.dao.UserDao;
import com.study.homework.pojo.Order;
import com.study.homework.pojo.R;
import com.study.homework.pojo.User;
import com.study.homework.service.UserService;
import com.study.homework.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    TokenUtil tokenUtil;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    public R Login(String username, String password, HttpServletResponse response) {
        User user2 = userDao.getUserByUsername(username);
        if (user2 == null) {
            return new R(7, "该用户不存在！", null);
        }
        if (!user2.getPassword().equals(password)) {
            return new R(7, "密码错误！", null);
        }

        String token = tokenUtil.generateToken(user2);
        Cookie cookie = new Cookie("token", token);
//        设置cookie的作用域：为”/“时，以在webapp文件夹下的所有应用共享cookie
        cookie.setPath("/");
        response.addCookie(cookie);
        new Object();
        return new R(20000, "登陆成功！", null);
    }

    public R Register(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            return new R(7, "当前用户名已存在", null);
        }
        int res = userDao.addUser(username, password);
        return res == 1 ?
                new R(20000, "注册成功！", null) :
                new R(7, "注册失败！", null);
    }

    public User getInfo(HttpServletRequest request) {
        String token = tokenUtil.getToken(request);
        String username = TokenUtil.get(token);
        return getUserByUserName(username);
    }

    public User getUserByUserName(String username) {
        return userDao.getUserByUsername(username);
    }

    public int deleteUser(long id) {
        return userDao.deleteUser(id);
    }

    public R updateUser(User user) {
        User u1 = userDao.getUserById(user.getId());
        if (u1 == null) {
            return new R(7, "查询无该用户", null);
        }
        int r = userDao.updateUser(user.getId(), user.getReal_name(), user.getGender(), user.getAddress(), user.getPhone(),
                user.getRole(), user.getAge());
        if (r == 1) {
            return new R(20000, "更新用户信息成功", userDao.getUserById(user.getId()));
        } else {
            return new R(7, "更新用户信息失败", null);
        }
    }
}
