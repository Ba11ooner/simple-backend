package com.example.crud.common;

//ErrorCode 是写给前端看的
// 枚举类型的格式为
// 1.声明枚举对象
// 2.声明枚举对象属性
// 3.声明构造函数
public enum ErrorCode {
    //预定义的 ErrorCode, 用于描述错误信息
    NULL_ERROR(40000, "请求数据为空", ""),
    PARAMS_ERROR(40001, "请求参数错误", ""),
    SYSTEM_ERROR(50000, "系统内部异常", "");

    private final int code;
    private final String message;
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    public String getDescription() {
        return description;
    }
}
