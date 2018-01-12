package com.love.marriage.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Crete by Marlon
 * Create Date: 1/11/2018
 * Class Describe
 **/

@Data
public class PartnerClaimForm {

    @NotEmpty(message = "UserId 不能为空")
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
