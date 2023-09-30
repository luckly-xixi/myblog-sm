package com.example.demo.common;

import lombok.Data;

/**
 * 前后端交互的同一对象
 */

@Data
public class ResultAjax {
    private int code;
    private String msg;
    private Object data;

    public static ResultAjax success(Object data) {
        ResultAjax result = new ResultAjax();
        result.setCode(200);
        result.setMsg("");
        result.setData(data);
        return result;
    }


    public static ResultAjax success(int code, String msg, Object data) {
        ResultAjax result = new ResultAjax();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


    public static ResultAjax fail(int code, String msg) {
        ResultAjax result = new ResultAjax();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static ResultAjax fail(int code, String msg, Object data) {
        ResultAjax result = new ResultAjax();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
