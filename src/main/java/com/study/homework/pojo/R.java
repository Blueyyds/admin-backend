package com.study.homework.pojo;

public class R {
    private Integer code;
    private String msg;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", message='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public R(Integer code, String message, Object data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }
}
