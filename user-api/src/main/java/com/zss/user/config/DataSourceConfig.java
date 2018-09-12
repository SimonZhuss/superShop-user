package com.zss.user.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

	@Value("${spring.datasource.type}")
	private Class<? extends DataSource> dataSourceType;
	
 
	@Bean(name = "masterDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.druid.master")
	public DataSource masterDataSource() throws SQLException{
		DataSource masterDataSource = DataSourceBuilder.create().type(dataSourceType).build();
		LOGGER.info("========MASTER: {}=========", masterDataSource);
		return masterDataSource;
	}
 
	@Bean(name = "slaveDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.slave")
	public DataSource slaveDataSource(){
		DataSource slaveDataSource = DataSourceBuilder.create().type(dataSourceType).build();
		LOGGER.info("========SLAVE: {}=========", slaveDataSource);
		return slaveDataSource;
	}
}
