package com.lbh360.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer // 启动ZipkinServer段
public class ZipkinServer {
	public static void main(String[] args) {
		SpringApplication.run(ZipkinServer.class, args);
	}
}