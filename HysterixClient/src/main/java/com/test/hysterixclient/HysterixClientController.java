package com.test.hysterixclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HysterixClientController {
	
	@Autowired
	ServiceBOImpl sbInterface;

	
	@RequestMapping(value = "/rest/ping", method = RequestMethod.GET)
	public String greeting(){
		return "Hysterix Client Service is Up";
	}
	
	
	@RequestMapping("/rest/getAllEmployees")
    @ResponseBody
    public List<EmployeeBean> getAllEmployees() {
        return sbInterface.getEmployees();
    }
	
	@RequestMapping("/rest/getAllEmployeesWithHysterix")
    @ResponseBody
    public List<EmployeeBean> getAllEmployeesWithHysterix() {
        List<DepartmentBean> deptBeanList = sbInterface.getDepartments();
		List<EmployeeBean> empBeanList = sbInterface.getEmployees();
		
		if(empBeanList != null && empBeanList.size() > 0){
			for(EmployeeBean e : empBeanList){
				for(DepartmentBean d : deptBeanList){
					if(d.getDepartmentId() == e.getDepartmentId()){
						e.setDepartName(d.getDepartmentName());
						break;
					}
				}
			}
		}
		return empBeanList;
    }
}
