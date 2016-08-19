package com.test.hysterixclient;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("department-service")
public interface DepartmentRestInterface {
	@RequestMapping(method = RequestMethod.GET, value = "/dept/getDepartments")
	List<DepartmentBean> getDepartments();
}
