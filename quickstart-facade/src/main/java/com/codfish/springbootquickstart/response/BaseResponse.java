package com.codfish.springbootquickstart.response;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 3345108257135498209L;

    private Integer status;

    private String msg;

    private T data;

    public BaseResponse success(T data) {
        this.status = 0;
        this.msg = "success";
        this.data = data;

        return this;
    }

    public BaseResponse success(T data, String msg) {
        this.status = 0;
        this.msg = msg;
        this.data = data;

        return this;
    }

    public BaseResponse error(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = null;

        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
