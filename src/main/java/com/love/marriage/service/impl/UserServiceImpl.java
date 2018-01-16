package com.love.marriage.service.impl;

import com.love.marriage.dataobject.bean.User;
import com.love.marriage.dataobject.dao.UserDao;
import com.love.marriage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int registerUser(User user) {
        return userDao.registerUser(user);
    }

    @Override
    public List<User> selectUsers() {
        return userDao.selectUsers();
    }

    @Override
    public int alterPassword(User user) {
        return userDao.updatePasswordByPhone(user);
    }

    @Override
    public boolean userExist(String phone) {
        User user = userDao.findUserByPhone(phone);
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public User loginUser(String phone, String password) {
        return userDao.loginUser(phone, password);
    }


}
