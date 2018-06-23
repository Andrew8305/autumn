package com.cloud.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.cloud.user.dao")
@EnableTransactionManagement
@EnableFeignClients({"com.cloud.auth.server.feign"})
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
