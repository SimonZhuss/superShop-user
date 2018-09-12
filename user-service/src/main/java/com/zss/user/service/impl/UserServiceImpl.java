package com.zss.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zss.user.constants.UserRespEnum;
import com.zss.user.domain.UserInfo;
import com.zss.user.entity.BaseResEntity;
import com.zss.user.entity.ResponseEntity;
import com.zss.user.mapper.UserMapper;
import com.zss.user.service.UserService;

/**
 * 用户实现类
 * @author zhushanshan
 * 2017年11月18日 下午3:14:41
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper; 

	@Override
	public BaseResEntity addUser(UserInfo userInfo) {
		userMapper.insertSelective(userInfo);
		return BaseResEntity.success();
	}

	@Override
	public BaseResEntity queryUser(Long id) {
		ResponseEntity<UserInfo> resEntity = new ResponseEntity<UserInfo>(
				UserRespEnum.SUCCESS);
		resEntity.setData(userMapper.selectByPrimaryKey(id));
		return resEntity;
	}

	@Override
	public BaseResEntity queryByCondition(UserInfo user) {
		ResponseEntity<UserInfo> resEntity = new ResponseEntity<UserInfo>(
				UserRespEnum.SUCCESS);
		resEntity.setData(userMapper.queryByCondition(user));
		return resEntity;
	}
}
