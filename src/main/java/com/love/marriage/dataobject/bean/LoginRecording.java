package com.love.marriage.dataobject.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Crete by Marlon
 * Create Date: 1/11/2018
 * Class Describe
 **/

@Data
@Entity
public class LoginRecording {

    @Id
    private Integer loginId;
    private Integer userId;
    private Integer loginStatus;
    private Double loginLatitude;
    private Double loginLongitude;

    public LoginRecording(Integer userId, int loginStatus, double loginLatitude, double loginLongitude) {
        this.userId = userId;
        this.loginStatus = loginStatus;
        this.loginLatitude = loginLatitude;
        this.loginLongitude = loginLongitude;
    }


}
