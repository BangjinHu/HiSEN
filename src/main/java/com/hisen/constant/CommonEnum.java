package com.hisen.constant;

/**
 * 这里的枚举类型，然后IDEA中代码小写转换为大写快捷键：Ctrl+shif+U
 */
public enum CommonEnum {
    LOGIN_FAILD(1,"登录失败，账号或者密码错误！"),
    LOGIN_SUCCESS(2,"登录成功！"),
    LOGIN_LOCKED(3,"账号被锁，请重新设置密码！"),
    REQUEST_SUCCESS(4,"请求成功！"),
    REQUEST_FAILED(5,"请求失败！"),
    //JWT如何实现？
    JWT_SECRET(6,"xx#$%()(#*!()!kl<><mqlmnqnqjqk sdfkjsdrow32234545df>?n<:{lwpw_hisen"),
    JWT_PAYLOAD(7,"payload"),
    //一小时
    JWT_MAXAGE(8,"3600000"),;

    private int code;
    private String msg;

    CommonEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
