package com.love.marriage.service.impl;

import com.love.marriage.dataobject.bean.UserRole;
import com.love.marriage.dataobject.repository.UserRoleRepository;
import com.love.marriage.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Crete by Marlon
 * Create Date: 1/12/2018
 * Class Describe
 **/

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole create(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole save(UserRole role) {
        return userRoleRepository.save(role);
    }

    @Override
    public List<UserRole> findAllUserRoles() {
        return userRoleRepository.findAll();
    }
}
