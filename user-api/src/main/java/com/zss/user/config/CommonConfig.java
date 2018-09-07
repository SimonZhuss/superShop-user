package com.zss.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 读取自定义文件的数据
 * @author zhushanshan
 *
 */
/*@ConfigurationProperties(prefix = "common")
@Configuration
@PropertySource(value = "file:${USER_CONFIG}/config/common.properties") */
public class CommonConfig {
	private String instanceId;

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
}
