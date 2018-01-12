package com.love.marriage.dataobject.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 **/

//@Table(name ="product_category")
@Entity
@DynamicUpdate  //进行更新
@Data
public class User {

    @Id
    private String userId;

    private String userPhone;

    private String userPassword;

    public User() {

    }

    public User(String userId, String userPassword, String userPhone) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
    }


}
