package com.love.marriage.service;

import com.love.marriage.dataobject.bean.User;

import java.util.List;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 **/

public interface UserService {

    public int registerUser(User user);

    public List<User> selectUsers();

    public int alterPassword(User user);

    public boolean userExist(String phone);

}
