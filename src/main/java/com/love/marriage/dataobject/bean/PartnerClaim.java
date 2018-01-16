package com.love.marriage.dataobject.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Crete by Marlon
 * Create Date: 1/11/2018
 * Class Describe
 * 很多条件写的不太仔细，主要是没有做过。然后希望自己在以后的时候能修改过来
 **/


@Data
@Entity
public class PartnerClaim {

    @Id
    private Integer userId;

    private Integer partnerMinage;

    private Integer partnerAge;

    private Integer partnerMaxage;

    private String partnerBirthCity;

    private String partnerLiveCity;

    private Integer partnerHight;  //代指最低身高 身高也是有范围

    private String partnerIncomeLevel;

    private String partnerEducationLevel;

    private String partnerRealEstate;


}
