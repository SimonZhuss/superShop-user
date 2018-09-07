package com.zss.user.entity;

import com.zss.user.constants.UserRespEnum;
import com.zss.user.exception.UserException;

public class BaseResEntity {
    private String code;
    private String message;

    public BaseResEntity() {
        this.code = UserRespEnum.SUCCESS.getCode();
        this.message = UserRespEnum.SUCCESS.getMessage();
    }

    public BaseResEntity(String code, String message) {
        this.code = code;
        this.message = message;
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

    public static BaseResEntity failure() {
        return new BaseResEntity(UserRespEnum.BUSINESS_ERROR.getCode(), UserRespEnum.BUSINESS_ERROR.getMessage());
    }
    
    public static BaseResEntity failure(String message) {
        return new BaseResEntity(UserRespEnum.BUSINESS_ERROR.getCode(), message);
    }
    
    public static BaseResEntity failure(UserRespEnum message) {
        return new BaseResEntity(message.getCode(), message.getMessage());
    }

    public static BaseResEntity failure(UserException e) {
        return new BaseResEntity(e.getCode(), e.getMsg());
    }

    public static BaseResEntity success() {
        return new BaseResEntity(UserRespEnum.SUCCESS.getCode(), UserRespEnum.SUCCESS.getMessage());
    }

}
