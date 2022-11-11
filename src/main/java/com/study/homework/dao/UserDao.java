package com.study.homework.dao;

import com.study.homework.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM user where is_deleted != 1")
    public List<User> getAllUsers();


    @Select("select * from user where id = #{id}")
    public User getUserById(long id);

    @Insert("insert into user(username, password) values(#{username}, #{password})")
    public int addUser(String username, String password);

    @Select("select * from user where username = #{username}")
    public User getUserByUsername(String username);

    @Delete("update user set is_deleted = 1 where id = #{id}")
    public int deleteUser(long id);

    @Update("UPDATE user SET real_name = #{real_name}, gender = #{gender} ,address = #{address}," +
            " phone = #{phone}, role = #{role}, age = #{age} WHERE id = #{id};")
    public int updateUser(long id, String real_name, String gender, String address, String phone, String role, int age);
}
