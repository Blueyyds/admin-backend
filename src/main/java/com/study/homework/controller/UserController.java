package com.study.homework.controller;

import com.study.homework.pojo.R;
import com.study.homework.pojo.User;
import com.study.homework.service.UserService;
import com.study.homework.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R Login(@RequestBody User user, HttpServletResponse response){
        return userService.Login(user.getUsername(), user.getPassword(), response);
    }

    @PostMapping("/register")
    public R Register(@RequestBody User user){
        return userService.Register(user.getUsername(), user.getPassword());
    }

    @GetMapping("/logout")
    public R Logout(){
        return new R(20000, "退出登录成功！", null);
    }

    @GetMapping("/getAllUsers")
    public R getAllUsers() {
        List<User> userList = userService.getAllUsers();
        if (userList != null && userList.size() > 0) {
            return new R(20000, "获取用户列表成功！", userList);
        } else {
            return new R(7, "获取用户列表失败！", userList);
        }
    }

    @GetMapping("/getInfo")
    public R getInfo(HttpServletRequest request) {
//              return new R(20000, "获取用户信息成功！", null);
        User user = userService.getInfo(request);
        if (user == null) {
            return new R(7, "获取用户信息失败！", null);
        } else {
            return new R(20000, "获取用户信息成功！", user);
        }
    }

    @GetMapping("/getById")
    public R getById(@RequestParam long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new R(20000, "获取用户信息成功！", user);
        } else {
            return new R(7, "获取用户信息失败！", null);
        }
    }

    @DeleteMapping("/delete")
    public R deleteUser(@RequestParam int id) {
        int res = userService.deleteUser(id);
        System.out.println(res);
        if (res == 1) {
            return new R(20000, "删除用户成功！", null);
        } else {
            return new R(7, "删除用户失败！", null);
        }
    }

    @PutMapping("/updateUser")
    public R updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
