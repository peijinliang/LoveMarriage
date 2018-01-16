package com.love.marriage.service.impl;

import com.love.marriage.dataobject.bean.LoginRecording;
import com.love.marriage.dataobject.repository.LoginRecordingRepository;
import com.love.marriage.service.LoginRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Crete by Marlon
 * Create Date: 1/12/2018
 * Class Describe
 **/

@Service
public class LoginRecordServiceImpl implements LoginRecordService {

    @Autowired
    private LoginRecordingRepository loginRecordingRepository;

    @Override
    public Page<LoginRecording> findUserLoginRecording(int userId, Pageable pageable) {
        return loginRecordingRepository.findByUserId(userId, pageable);
    }

    @Override
    public LoginRecording createLoginLoginRecording(LoginRecording recording) {
        return loginRecordingRepository.save(recording);
    }

}
