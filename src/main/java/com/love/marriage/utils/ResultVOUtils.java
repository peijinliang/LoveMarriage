package com.love.marriage.utils;


import com.love.marriage.vo.ResultVO;
import com.love.marriage.enums.ResultEnum;

/**
 * Crete by Marlon
 * Create Date: {DATE}
 * Class Describe
 **/
public class ResultVOUtils {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(null);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(null);
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(null);
        resultVO.setMsg(resultEnum.getMessage());
        resultVO.setCode(resultEnum.getCode());
        return resultVO;
    }

}
