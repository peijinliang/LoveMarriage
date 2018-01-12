package com.love.marriage.dataobject;

import com.love.marriage.dataobject.bean.UserMessage;
import com.love.marriage.dataobject.repository.UserMessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMessageRepositoryTest {

    @Autowired
    private UserMessageRepository repository;

    @Test
    public void saveMessage() throws Exception {
        UserMessage userMessage = new UserMessage();
        userMessage.setUserId(1);
        userMessage.setUserSex(1);
        userMessage.setLiveCity("上海");
        userMessage.setBirthCity("德州");
        userMessage.setEducationLevel("本科");
        userMessage.setSelfIntroduction("我是一个好孩子，好孩子");
        userMessage.setUserHeight(178);
        userMessage.setUserAvater("我的梦想就是成就我自己" + "，从现在开始我把我做的每一件事情都是为了我心中的梦想。成为CEO。而剩下的仅仅就是成长的过程而已");
        userMessage.setIncomeLevel("2000-5000");
        userMessage.setUserOccupation("工程师");
        userMessage.setIntroduceVideo("这个就是我的视频");
        System.out.println("userMessage------------" + userMessage.toString());
        UserMessage message = repository.save(userMessage);
        System.out.println("0------------" + message.toString());
    }

    @Test
    public void findOneByUser_id() throws Exception {
        UserMessage userMessage = repository.findOne(1);
        System.out.println("userMessage------------" + userMessage.toString());
    }

    @Test
    public void updateUserHeight() throws Exception {
        UserMessage userMessage = repository.findOne(1);
        userMessage.setUserHeight(190);
        repository.save(userMessage);
    }

}
