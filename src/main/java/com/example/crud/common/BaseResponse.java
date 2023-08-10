package com.example.crud.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用的前端友好型响应对象
 * @param <T> 数据类型
 */
@Data
public class BaseResponse<T> implements Serializable {
    private int code; //状态码
    private T data; //返回数据
    private String message; //状态信息
    private String description; //状态描述

    BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(ErrorCode errorCode, T data) {
        this.code = errorCode.getCode();
        this.data = data;
        this.message = errorCode.getMessage();
        this.description = errorCode.getDescription();
    }

}
