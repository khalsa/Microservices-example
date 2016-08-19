package com.test.hysterixclient;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("employee-service")
public interface EmployeeRestInterface {
	@RequestMapping(method = RequestMethod.GET, value = "/emp/getEmployees")
	List<EmployeeBean> getEmployees();
}
