package com.love.marriage.controller;

import com.love.marriage.dataobject.bean.LoginRecording;
import com.love.marriage.dataobject.bean.User;
import com.love.marriage.enums.LoginStatusEnum;
import com.love.marriage.service.LoginRecordService;
import com.love.marriage.vo.ResultVO;
import com.love.marriage.enums.ResultEnum;
import com.love.marriage.exception.LoveException;
import com.love.marriage.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import com.love.marriage.service.UserService;

import java.util.List;

/**
 * Crete by Marlon
 * Create Date: 1/9/2018
 * Class Describe
 * 查询全部用户的登录记录没有任何价值
 * 还需要一个复查的条件查询语句
 **/


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginRecordService loginRecordService;

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

//    @PostMapping("/login")
//    public ResultVO<List<User>> userLogin(@RequestParam(value = "phone") String phone,
//                                          @RequestParam(value = "password") String password) {
//
//        if (!userService.userExist(phone)) {
//            return ResultVOUtils.error(ResultEnum.NOT_REGISTER_ERROR);
//        }
//        User user = userService.loginUser(phone, password);
//        if (user == null) {
//            return ResultVOUtils.error(ResultEnum.LOGIN_PASSWORD_ERROR);
//        }
//        loginRecordService.createLoginLoginRecording(new LoginRecording(Integer.parseInt(user.getUserId()), LoginStatusEnum.LoginIn.getStatus(), 0f, 0f));
//        return ResultVOUtils.success(user);
//    }


    @GetMapping("/loginrecord")
    private ResultVO<List<LoginRecording>> findUserRecorde(@RequestParam("userId") String userId,
                                                           @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                           @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = new PageRequest(page, size);
        Page<LoginRecording> orderDTOPage = loginRecordService.findUserLoginRecording(Integer.parseInt(userId), request);
        return ResultVOUtils.success(orderDTOPage.getContent());
    }


}

