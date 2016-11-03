package com.test.hysterixclient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

@Service
public class ServiceBOImpl{
	
	@Autowired
	EmployeeRestInterface empInterface;
	
	@Autowired
	DepartmentRestInterface deptInterface;

	@HystrixCommand(fallbackMethod = "fallBackEmployeeCall")
	public List<EmployeeBean> getEmployees() {
		return empInterface.getEmployees();
	}
	
	@HystrixCommand(fallbackMethod = "fallBackDepartmentCall")
	public List<DepartmentBean> getDepartments() {
		return deptInterface.getDepartments();
	}
	
	
	public List<EmployeeBean> fallBackEmployeeCall() {
		return new ArrayList<EmployeeBean>();
	}

	public List<DepartmentBean> fallBackDepartmentCall() {
        return new ArrayList<DepartmentBean>();
    }
	
}
