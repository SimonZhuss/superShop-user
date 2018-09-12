package com.zss.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zss.user.domain.UserInfo;
import com.zss.user.entity.BaseResEntity;
import com.zss.user.entity.ResponseEntity;
import com.zss.user.req.UserReq;
import com.zss.user.service.UserService;

/**
 * 用户控制器
 * @author zhushanshan
 * 2017年11月1日 下午6:19:33
 */
@Api(value = "用户制器")
@RestController
@RequestMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class UserController {

   /* @Autowired
    CommonConfig commonConfig;*/
    
    @Autowired
    private UserService userService;
    
	@ApiOperation(value = "新增用户", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = ResponseEntity.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
    public BaseResEntity add(@RequestBody UserInfo user){
        try{
        	//log.info(">>>>>>{}",commonConfig.getInstanceId());
        	BaseResEntity result =userService.addUser(user);
        	return result;
        }catch(Exception e){
            log.error("发生异常:",e);
            return BaseResEntity.failure();
        }
    }
	
	@ApiOperation(value = "根据条件查用户", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = ResponseEntity.class)
    @RequestMapping(value = "/queryByCondition", method = RequestMethod.POST)
	@ResponseBody
    public BaseResEntity queryByCondition(@RequestBody UserReq userreq){
        try{
        	BaseResEntity result =userService.queryByCondition(userreq);
        	return result;
        }catch(Exception e){
            log.error("发生异常:",e);
            return BaseResEntity.failure();
        }
    }
}
