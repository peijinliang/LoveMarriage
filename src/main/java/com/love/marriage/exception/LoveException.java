package com.love.marriage.exception;

import com.love.marriage.enums.ResultEnum;
import lombok.Getter;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 **/
@Getter
public class LoveException extends RuntimeException {

    private Integer code;
    private String mssage;

    public LoveException(ResultEnum result) {
        super(result.getMessage());
    }

    public LoveException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
