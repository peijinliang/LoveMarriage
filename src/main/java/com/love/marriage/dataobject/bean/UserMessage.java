package com.love.marriage.dataobject.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 * jpa 去实现用户详情
 **/

@Data
@Entity
public class UserMessage {

    @Id
    private int id;

    private int userId;

    private String userName;

    private int userSex;

    private String userAvater;

    private String liveCity;

    private String birthCity;

    private int userHeight;

    private String userOccupation;

    private String incomeLevel;

    private String educationLevel;

    private String selfIntroduction;

    private String introduceVideo;

    private int accountCredits;

}
