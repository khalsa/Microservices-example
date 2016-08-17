package com.rest.department;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@EnableDiscoveryClient
@RestController
public class DepartmentRestController {
	private List<DepartmentBean> deptList;
	
	@PostConstruct
	public void init() {
		deptList = new ArrayList<DepartmentBean>();
		deptList.add(new DepartmentBean(300, "I.T"));
		deptList.add(new DepartmentBean(301, "Accounts"));
		deptList.add(new DepartmentBean(302, "Finances"));
	}
	
	@RequestMapping(value = "/dept/ping", method = RequestMethod.GET)
	public String greeting(){
		return "Department Service is Up.";
	}
	
	@RequestMapping(value = "/dept/getDepartments", method = RequestMethod.GET)
	public List<DepartmentBean> getDepartments(){
		return deptList;
	}
	
}
