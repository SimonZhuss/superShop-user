package com.zss.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zss.user.domain.UserInfo;

public interface UserMapper {
	
    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);
    
    List<UserInfo> queryByCondition(UserInfo user);
}