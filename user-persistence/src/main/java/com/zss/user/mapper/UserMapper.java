package com.zss.user.mapper;

import java.util.List;

import com.zss.user.domain.UserInfo;

public interface UserMapper {
	
    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);
    
    List<UserInfo> queryByCondition(UserInfo user);
}