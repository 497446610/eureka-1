package com.lbh360.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 说明: 功能描述
 * @author 况小锋
 * @version 1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.lbh360.platform.dao")
public class PlatformBootApplication {
	/**
	 * 
	 * 功能说明：启动应用
	 * 
	 * @author 况小锋
	 * @param args
	 *            动态参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(PlatformBootApplication.class, args);
	}
}
