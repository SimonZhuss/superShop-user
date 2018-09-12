package com.zss.user.service;

import com.zss.user.domain.UserInfo;
import com.zss.user.entity.BaseResEntity;
import com.zss.user.req.UserReq;

/**
 * 用户服务层
 * @author zhushanshan
 * 2017年11月18日 下午2:30:41
 */
public interface UserService {

	public BaseResEntity addUser(UserInfo userInfo);
	
	public BaseResEntity queryUser(Long id);
	
	public BaseResEntity queryByCondition(UserReq userreq);
}
