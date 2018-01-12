package com.love.marriage.dataobject.mapper;

import com.love.marriage.dataobject.bean.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", "10000");
        map.put("user_phone", "13761022837");
        map.put("user_password", "123456");
        int result = userMapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() throws Exception {
        User user = new User("100001", "123456", "13764537465");
        int result = userMapper.insertByObject(user);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByUserId() throws Exception {
//        User user = userMapper.findUserById("10000");
//        log.error(user.toString());
//        Assert.assertNotNull(user);
    }

    @Test
    public void updateUserPassword() throws Exception {
        int result = userMapper.updatePasswordByUserId("100001", "666666");
        Assert.assertNotEquals(0, result);
    }

    @Test
    public void alterUserPassword() throws Exception {
        User user = new User();
        user.setUserPhone("13761022837");
        user.setUserPassword("123123");
        int result = userMapper.updatePasswordByPhone(user);
        Assert.assertNotEquals(0, result);
    }

    @Test
    public void findUsers() throws Exception {
        List<User> list = userMapper.findUsers();
        System.out.println("---------------------" + list.toString());
    }


    @Test
    public void selectUserById() throws Exception {
        User result = userMapper.selectUserById("10000");
        System.out.println("---------------------" + result.toString());
    }


}