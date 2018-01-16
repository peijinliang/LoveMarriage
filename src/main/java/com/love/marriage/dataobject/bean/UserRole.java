package com.love.marriage.dataobject.bean;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Crete by Marlon
 * Create Date: 1/12/2018
 * Class Describe
 **/

@Data
@Entity
public class UserRole {

    @Id
    private Integer roleId;

    private Integer roleType;

    private String roleDesc;

}
