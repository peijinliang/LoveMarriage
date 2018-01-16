package com.love.marriage.service.impl;

import com.love.marriage.dataobject.bean.UserMessage;
import com.love.marriage.dataobject.repository.UserMessageRepository;
import com.love.marriage.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 **/

@Service
public class UserMessageServiceImpl implements UserMessageService {

    @Autowired
    private UserMessageRepository userMessageRepository;

    @Override
    public UserMessage save(UserMessage userMessage) {
        return userMessageRepository.save(userMessage);
    }

    @Override
    public UserMessage findOneByUserId(int userId) {
        return userMessageRepository.findByUserId(userId);
    }

    @Override
    public UserMessage updateNickName(int userId, String userName) {
        UserMessage userMessage = userMessageRepository.findByUserId(userId);
        userMessage.setUserName(userName);
        return userMessageRepository.save(userMessage);
    }

    @Override
    public void updateAvaterByUserId(int userId, String avater) {
        UserMessage userMessage = userMessageRepository.findByUserId(userId);
        userMessage.setUserAvater(avater);
        userMessageRepository.save(userMessage);
    }

    @Override
    public void updateSelfIntroduction(int userId, String selfintroduction) {
        UserMessage userMessage = userMessageRepository.findByUserId(userId);
        userMessage.setSelfIntroduction(selfintroduction);
        userMessageRepository.save(userMessage);
    }

    @Override
    public void updateIntroduceVideo(int userId, String videUrl) {
        UserMessage userMessage = userMessageRepository.findByUserId(userId);
        userMessage.setIntroduceVideo(videUrl);
        userMessageRepository.save(userMessage);
    }

    //增加积分  减少积分
    @Override
    public int updateAccountCredits(int userId, int credits) {
        UserMessage userMessage = userMessageRepository.findByUserId(userId);
        userMessage.setAccountCredits(credits);
        return credits;
    }


}
