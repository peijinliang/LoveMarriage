package com.love.marriage.enums;

import lombok.Getter;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 * 100 通用类型
 * 200 注册流程
 * 300 用户流程
 * 意思就是根据不同的流程设置间隔
 **/
@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数不正确"),
    REGISTER_REPEAT_ERROR(2, "该手机号已经被注册"),
    NOT_REGISTER_ERROR(3, "该手机号尚未被注册"),
    NOT_USERMESSAGE_ERROR(4, "该用户信息尚未填写"),
    LOGIN_PASSWORD_ERROR(5, "密码错误");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
