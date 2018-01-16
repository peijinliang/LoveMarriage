package com.love.marriage.service;

import com.love.marriage.dataobject.bean.LoginRecording;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Crete by Marlon
 * Create Date: 1/12/2018
 * Class Describe
 * 插入登出记录
 **/
public interface LoginRecordService {

    /**
     * 分页查询某一个用户的登录记录
     *
     * @param userId
     * @param pageable
     * @return
     */
    Page<LoginRecording> findUserLoginRecording(int userId, Pageable pageable);


    /**
     * 插入登录记录/登出记录
     *
     * @param recording
     * @return
     */
    LoginRecording createLoginLoginRecording(LoginRecording recording);


}
