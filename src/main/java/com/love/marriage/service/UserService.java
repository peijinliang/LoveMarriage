package com.love.marriage.service;

import com.love.marriage.dataobject.bean.User;

import java.util.List;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 * 我是依赖注入了，但是我注入的是接口。系统就默认给我找到他的实现方法
 **/
public interface UserService {

    public int registerUser(User user);

    public List<User> selectUsers();

    public int alterPassword(User user);

    public boolean userExist(String phone);

    public User loginUser(String phone, String password);

}
