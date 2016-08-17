package com.rest.employee;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class EmployeeRestController {
	
	private List<EmployeeBean> empList;
	
	@Value("${server.port}")
    private String portNo;

	
	@PostConstruct
	public void init() {
		empList = new ArrayList<EmployeeBean>();
		empList.add(new EmployeeBean(100, "Saurabh Verma", 301, 25));
		empList.add(new EmployeeBean(101, "Gaurav Verma", 302, 30));
	}
	
	@RequestMapping(value = "/emp/ping", method = RequestMethod.GET)
	public String greeting(){
		return "Employee Service is Up.";
	}
	
	@RequestMapping(value = "/emp/getEmployees", method = RequestMethod.GET)
	public List<EmployeeBean> getEmployees(){
		System.out.println("Employee Service called on port : " + portNo);
		return empList;
	}
}
