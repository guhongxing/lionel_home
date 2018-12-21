package com.lionel.bean.commons;

/**
 * @ClassName ResultDTO
 * @Description todo
 * @Author guhongxing
 * @Date 2018/12/21 15:58
 **/
public class ResultDTO {
    private String code;
    private String message;

    public ResultDTO() {
        this.message = "success";
        this.code = "200";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
