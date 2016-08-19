package com.test.hysterixclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableEurekaClient
@EnableWebMvc
@EnableFeignClients
@EnableCircuitBreaker
@Configuration
public class HysterixClientWeb extends SpringBootServletInitializer{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HysterixClientWeb.class, args);
	}
}
