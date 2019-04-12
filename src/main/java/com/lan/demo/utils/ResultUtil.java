package com.lan.demo.utils;

import com.lan.demo.enums.ResultEnum;
import lombok.Data;

/**
 * @author: Lan
 * @date: 2019/4/8 15:34
 * @description:
 */
@Data
public class ResultUtil<T> {

    private Integer code;

    private String msg;

    private T data;

    public ResultUtil() {
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResultUtil success(Object data) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setData(data);
        return resultUtil;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultUtil success() {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        return resultUtil;
    }

    /**
     * 错误返回
     *
     * @param resultEnum
     * @return
     */
    public static ResultUtil error(ResultEnum resultEnum) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(resultEnum.getCode());
        resultUtil.setMsg(resultEnum.getMsg());
        return resultUtil;
    }

    /**
     * 返回失败
     *
     * @param msg
     * @return
     */
    public static ResultUtil error(String msg) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(-1);
        resultUtil.setMsg(msg);
        return resultUtil;
    }
}
