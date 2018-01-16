package com.love.marriage.controller;

import com.love.marriage.config.ProjectUrlConfig;
import com.love.marriage.service.LoginRecordService;
import com.love.marriage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Crete by Marlon
 * Create Date: 1/16/2018
 * Class Describe
 * 登录和登出记录的状态都是要采用切片的方式去写
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginRecordService loginRecordService;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView userLogin(HttpServletResponse response,
                                  Map<String, Object> map) {
        return new ModelAndView("redirect:" + projectUrlConfig.getLoveMarry() + "/");
    }

}
