package com.love.marriage.service;


import com.love.marriage.dataobject.bean.UserRole;
import java.util.List;

/**
 * Crete by Marlon
 * Create Date: 1/12/2018
 * Class Describe
 **/

public interface UserRoleService {

    //新增角色
    public UserRole create(UserRole userRole);

    //修改角色
    public UserRole save(UserRole role);

    //查询所用用户的角色
    public List<UserRole> findAllUserRoles();

}
