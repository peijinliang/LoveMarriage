package com.love.marriage.form;

import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Crete by Marlon
 * Create Date: 1/12/2018
 * Class Describe
 **/

@Getter
public class UserRoleForm {

    @NotEmpty(message = "用户类型不能为空")
    private Integer roleType;

    @NotEmpty(message = "用户描述不能为空")
    private String roleDesc;

}
