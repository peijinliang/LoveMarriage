package com.love.marriage.controller;

import com.love.marriage.dataobject.bean.UserRole;
import com.love.marriage.enums.ResultEnum;
import com.love.marriage.exception.LoveException;
import com.love.marriage.form.UserRoleForm;
import com.love.marriage.service.UserRoleService;
import com.love.marriage.utils.ResultVOUtils;
import com.love.marriage.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Crete by Marlon
 * Create Date: 1/12/2018
 * Class Describe
 **/

@RestController
@RequestMapping("/role")
@Slf4j
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/create")
    public ResultVO<UserRole> createUserRole(@Valid UserRoleForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确 ,orderForm={}", orderForm);
            throw new LoveException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(orderForm, userRole);
        UserRole role = userRoleService.save(userRole);
        return ResultVOUtils.success(role);
    }

    @PutMapping("/save")
    public ResultVO<UserRole> saveUserRole(@RequestParam("roleId") int roleId,
                                           @RequestParam(value = "roleType") int roleType,
                                           @RequestParam(value = "roleDesc") String roleDesc) {
        if (roleId == 0) {
            throw new LoveException(ResultEnum.PARAM_ERROR.getCode(), "roleId not found");
        }
        if (StringUtils.isEmpty(roleDesc)) {
            throw new LoveException(ResultEnum.PARAM_ERROR.getCode(), "roleDesc not found");
        }
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        userRole.setRoleType(roleType);
        userRole.setRoleDesc(roleDesc);
        UserRole role = userRoleService.save(userRole);
        return ResultVOUtils.success(role);
    }

    @GetMapping("/list")
    public ResultVO<List<UserRole>> findAllUserRoles() {
        return ResultVOUtils.success(userRoleService.findAllUserRoles());
    }

}
