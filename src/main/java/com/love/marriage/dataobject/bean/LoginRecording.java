package com.love.marriage.dataobject.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

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

    private Timestamp loginIntime;

    private Double loginLatitude;

    private Double loginLongitude;


}
