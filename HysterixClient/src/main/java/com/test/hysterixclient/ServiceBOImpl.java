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
		// TODO Auto-generated method stub
		System.out.println("ThreadNAme getEmployeesAsyncWithCompletionFuture -----------> " + Thread.currentThread().getName());
		return empInterface.getEmployees();
	}

	public List<EmployeeBean> fallBackEmployeeCall() {
        return new ArrayList<EmployeeBean>();
    }
	
	@HystrixCommand(fallbackMethod = "fallBackEmployeeCall")
    public Future<List<EmployeeBean>> getEmployeesAsync() {
        return new AsyncResult<List<EmployeeBean>>() {
            @Override
            public List<EmployeeBean> invoke() {
                return empInterface.getEmployees();
            }
        };
    }
	
	@HystrixCommand(fallbackMethod = "fallBackEmployeeCall")
    public CompletableFuture<List<EmployeeBean>> getEmployeesAsyncWithCompletionFuture() {
		CompletableFuture<List<EmployeeBean>> empList = CompletableFuture.supplyAsync(() -> getEmployees());
		return empList;
    }
	
	@HystrixCommand(fallbackMethod = "fallBackDepartmentCall")
    public CompletableFuture<List<DepartmentBean>> getDepartmentsAsyncWithCompletionFuture() {
		CompletableFuture<List<DepartmentBean>> deptList = CompletableFuture.supplyAsync(() -> getDepartments());
		return deptList;    
	}


	
    public List<EmployeeBean> getEmployeesAsync2() {
        return getEmployeesAsyncWithCompletionFuture().join();
    }
	
	@HystrixCommand(fallbackMethod = "fallBackDepartmentCall")
	public List<DepartmentBean> getDepartments() {
		// TODO Auto-generated method stub
		System.out.println("ThreadNAme getDepartmentAsyncWithCompletionFuture -----------> " + Thread.currentThread().getName());
		return deptInterface.getDepartments();
	}
	
	public List<DepartmentBean> fallBackDepartmentCall() {
        return new ArrayList<DepartmentBean>();
    }
	
	@HystrixCommand(fallbackMethod = "fallBackDepartmentCall")
    public Future<List<DepartmentBean>> getDepartmentsAsync() {
        return new AsyncResult<List<DepartmentBean>>() {
            @Override
            public List<DepartmentBean> invoke() {
                return deptInterface.getDepartments();
            }
        };
    }

	public List<EmployeeBean> getEmployeeWithNames(){
		CompletableFuture<List<DepartmentBean>> fDeptBean = getDepartmentsAsyncWithCompletionFuture();
		CompletableFuture<List<EmployeeBean>> fEmpBean = getEmployeesAsyncWithCompletionFuture();
		List<DepartmentBean> deptBeanList = null;
		List<EmployeeBean> empBeanList = null;
		CompletableFuture.allOf(fDeptBean, fEmpBean).join();
		try {
			deptBeanList = fDeptBean.get();
			 empBeanList = fEmpBean.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	/*public List<EmployeeBean> getEmployeeWithNames(){
		Future<List<DepartmentBean>> fDeptBean = getDepartmentsAsync();
		Future<List<EmployeeBean>> fEmpBean = getEmployeesAsync();
		List<DepartmentBean> deptBeanList = null;
		List<EmployeeBean> empBeanList = null;
		try {
			deptBeanList = fDeptBean.get();
			 empBeanList = fEmpBean.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	}*/
	
	/*@HystrixCommand
	public List<EmployeeBean> getEmployeeWithNames(){
		Future<List<DepartmentBean>> fDeptBean = this.getDepartmentsAsync();
		Future<List<EmployeeBean>> fEmpBean = this.getEmployeesAsync();
		List<DepartmentBean> deptBeanList = null;
		List<EmployeeBean> empBeanList = null;
		try {
			 deptBeanList = fDeptBean.get();
			 empBeanList = fEmpBean.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	}*/
}
