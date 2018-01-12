package com.love.marriage.controller;

import com.love.marriage.dataobject.bean.User;
import com.love.marriage.vo.ResultVO;
import com.love.marriage.enums.ResultEnum;
import com.love.marriage.exception.LoveException;
import com.love.marriage.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.love.marriage.service.UserService;

import java.util.List;

/**
 * Crete by Marlon
 * Create Date: 1/9/2018
 * Class Describe
 * 因为我开发的都是App,所以说暂不需要Web接口
 **/

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResultVO<List<User>> selectUsers() {
        return ResultVOUtils.success(userService.selectUsers());
    }

    @PostMapping("/create")
    public ResultVO<User> registerUser(@RequestParam(value = "phone") String phone,
                                       @RequestParam(value = "password") String password,
                                       @RequestParam(value = "code") String code) {
        if (code == null) {
            throw new LoveException(ResultEnum.PARAM_ERROR);
        }
        User user = new User();
        user.setUserPhone(phone);
        user.setUserPassword(password);
        if (userService.userExist(phone)) {
            userService.alterPassword(user);
        } else {
            userService.registerUser(user);
        }
        return ResultVOUtils.success(user);
    }

    @PutMapping("/update")
    public ResultVO<User> updatePassword(@RequestParam(value = "phone") String phone,
                                         @RequestParam(value = "password") String password,
                                         @RequestParam(value = "code") String code) {
        if (code == null) {
            return ResultVOUtils.error(ResultEnum.PARAM_ERROR);
        }
        if (!userService.userExist(phone)) {
            return ResultVOUtils.error(ResultEnum.NOT_REGISTER_ERROR);
        }
        User user = new User();
        user.setUserPhone(phone);
        user.setUserPassword(password);
        userService.alterPassword(user);
        return ResultVOUtils.success(user);
    }


}

