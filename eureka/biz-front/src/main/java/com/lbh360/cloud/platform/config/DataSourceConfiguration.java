package com.lbh360.cloud.platform.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 使用Hikari连接池做数据源
 * 
 * @author 况小锋
 * @version 1.0
 */
@Configuration
public class DataSourceConfiguration {

	@Bean(name = "dataSource")
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

}
