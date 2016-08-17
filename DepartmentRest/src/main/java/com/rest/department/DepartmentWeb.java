package com.rest.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;


@SpringBootApplication
public class DepartmentWeb extends SpringBootServletInitializer{
	public static void main(String args[]){
		SpringApplication.run(DepartmentWeb.class, args);
	}
}
