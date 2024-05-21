package com.pet_adoption.entity;

public class JSONResponse {

    public final static int SUCCESS = 200;
    public final static int FAIL = 0;

    private Integer code;         //接口编码
    private Integer status;       //成功与否代码 200 成功 0 失败
    private String msg;           //提示信息
    private Object data;          //数据

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JSONResponse() {
    }

    public JSONResponse(Integer code, Integer status, String msg, Object data) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public void makeSuccessResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.status = JSONResponse.SUCCESS;
        this.msg = msg;
        this.data = data;
    }

    public void makeFailResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.status = JSONResponse.FAIL;
        this.msg = msg;
        this.data = data;
    }

}