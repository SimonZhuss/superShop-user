package com.zss;

import java.io.File;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.StringUtils;
import com.zss.user.constants.UserConstants;

/**
 * 用户服务启动类
 * @author zhushanshan
 * 2017年11月1日 下午5:51:41
 */
@ServletComponentScan
@SpringBootApplication
@MapperScan(basePackages = "com.zss.user.mapper")
@EnableEurekaClient
@EnableFeignClients
@EnableScheduling
public class UserServerApplication {

    public static void main(String[] args) {
    	//String envPath = System.getenv(UserConstants.ENV_CONF_PATH.toUpperCase());
    	String envPath = "E:\\github-zss\\config\\user-server\\";
		if (StringUtils.isEmpty(envPath)) {
			throw new IllegalStateException(UserConstants.ENV_CONF_PATH.toUpperCase() + " is blank");
		}
		if (!envPath.endsWith(File.separator))
			envPath = envPath + File.separator;
		String configPath = envPath + "config" + File.separator;
		String logPath = envPath + "log" + File.separator;
		System.setProperty("spring.config.location", configPath);
		System.setProperty("log.base", logPath);
		System.setProperty("log.path", configPath);
        SpringApplication.run(UserServerApplication.class, args);
    }

}
