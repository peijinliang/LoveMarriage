package com.love.marriage.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 * jpa 去实现用户详情
 **/

@Data
public class UserMessageForm {

    @NotEmpty(message = "用户ID不能为空")
    private String userId;

    @NotEmpty(message = "用户姓名不能为空")
    private String userName;


    @NotEmpty(message = "请选择性别")
    private String userSex;

    @NotEmpty(message = "请选择居住城市")
    private String liveCity;

    @NotEmpty(message = "请选择成长城市")
    private String birthCity;

    @NotEmpty(message = "请填写您的身高")
    private String userHeight;

    @NotEmpty(message = "请填写您的职业")
    private String userOccupation;

    @NotEmpty(message = "请填写您的收入水平")
    private String incomeLevel;

    @NotEmpty(message = "请填写您的最高学历")
    private String educationLevel;

}
