package com.rest.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeWeb extends SpringBootServletInitializer{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(EmployeeWeb.class, args);
	}
}
