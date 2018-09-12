package com.zss.user.mapper;

import java.util.List;

import com.zss.user.domain.UserInfo;
import com.zss.user.req.UserReq;

public interface UserMapper {
	
    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);
    
    List<UserInfo> queryByCondition(UserReq userreq);
}