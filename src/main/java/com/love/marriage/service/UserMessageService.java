package com.love.marriage.service;

import com.love.marriage.dataobject.bean.UserMessage;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 * jpa 实现增删改查
 **/

public interface UserMessageService {

    public UserMessage save(UserMessage userMessage);

    public UserMessage findOneByUserId(int userId);

    public UserMessage updateNickName(int userId, String name);

    public void updateAvaterByUserId(int userId, String avater);

    public void updateSelfIntroduction(int userId, String selfintroduction);

    public void updateIntroduceVideo(int userId, String videUrl);

    public int updateAccountCredits(int userId, int credits);


}
