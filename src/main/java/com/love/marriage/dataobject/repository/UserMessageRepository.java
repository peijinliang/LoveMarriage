package com.love.marriage.dataobject.repository;

import com.love.marriage.dataobject.bean.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 **/
public interface UserMessageRepository extends JpaRepository<UserMessage, Integer> {

    UserMessage findByUserId(int userId);

}
