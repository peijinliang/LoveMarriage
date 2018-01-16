package com.love.marriage.enums;

/**
 * Crete by Marlon
 * Create Date: 1/12/2018
 * Class Describe
 **/
public enum LoginStatusEnum {

    LoginIn(1), LoginOut(0);

    private int status;

    LoginStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
