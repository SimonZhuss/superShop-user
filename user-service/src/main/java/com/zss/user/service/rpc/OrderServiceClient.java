package com.zss.user.service.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zss.user.entity.AjaxData;


/**
 * @Description:订单服务内部调用FeignClient
 * @auther zhushanshan
 * @since 2017年11月15日下午2:54:10
 */
@FeignClient(value="user-service")
@RequestMapping(value="order", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public interface OrderServiceClient {
   /* @RequestMapping(value = "/queryDetailInfo",method = RequestMethod.POST)
    AjaxData<ProductDetailInfo> querydetailInfo(@RequestBody ProductReqEntity req);*/
}
