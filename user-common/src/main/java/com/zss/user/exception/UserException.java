package com.zss.user.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.alibaba.fastjson.JSONObject;
import com.zss.user.constants.UserRespEnum;
import com.zss.user.entity.ResponseEntity;

/**
 * 业务异常
 * Created by baokezheng on 2017/10/12 0012.
 */
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class UserException extends RuntimeException{

	private static final long serialVersionUID = 5584943755890277011L;

	protected String code;
	protected String msg;
    
    public UserException(ResponseEntity baseResEntity){
        if(baseResEntity == null){
            this.code = UserRespEnum.SYSTEM_ERROR.getCode();
            this.msg = UserRespEnum.SYSTEM_ERROR.getMessage();
        }else{
            this.code = baseResEntity.getCode();
            this.msg = baseResEntity.getMessage();
        }
    }

    public UserException(UserRespEnum marketRespEnum){
        if(marketRespEnum == null){
            this.code = UserRespEnum.SYSTEM_ERROR.getCode();
            this.msg = UserRespEnum.SYSTEM_ERROR.getMessage();
        }else{
            this.code = marketRespEnum.getCode();
            this.msg = marketRespEnum.getMessage();
        }
    }

    public UserException(UserRespEnum marketRespEnum, String msg){
        if(marketRespEnum == null){
            this.code = UserRespEnum.SYSTEM_ERROR.getCode();
            this.msg = UserRespEnum.SYSTEM_ERROR.getMessage();
        }else{
            this.code = marketRespEnum.getCode();
            this.msg = marketRespEnum.getMessage() + msg;
        }
    }

    public UserException(String msg){
        this.code = UserRespEnum.BUSINESS_ERROR.getCode();
        this.msg = msg;
    }
    
    public UserException(JSONObject jsonObj){
        if(jsonObj == null){
            this.code = UserRespEnum.SYSTEM_ERROR.getCode();
            this.msg = UserRespEnum.SYSTEM_ERROR.getMessage();
        }
    }

}
