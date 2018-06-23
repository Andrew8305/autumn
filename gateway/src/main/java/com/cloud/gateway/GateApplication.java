package com.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@ComponentScan({"com.cloud.auth.client","com.cloud.gateway"})
@EnableFeignClients({"com.cloud.auth.client.feign"})
public class GateApplication {
	public static void main(String[] args) {
		SpringApplication.run(GateApplication.class, args);
	}
}
