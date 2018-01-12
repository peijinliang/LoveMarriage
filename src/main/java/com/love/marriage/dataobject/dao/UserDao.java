package com.love.marriage.dataobject.dao;

import com.love.marriage.dataobject.bean.User;
import com.love.marriage.dataobject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 **/
@Component
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    //注册
    public int registerUser(User user) {
        return userMapper.insertByObject(user);
    }

    //查询用户列表
    public List<User> selectUsers() {
        List<User> users = userMapper.findUsers();
        return users;
    }

    //重置密码
    public int updatePasswordByPhone(User user) {
        return userMapper.updatePasswordByPhone(user);
    }

    public User findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }


}
