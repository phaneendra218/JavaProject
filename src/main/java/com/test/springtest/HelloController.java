package com.test.springtest;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	Date d = new Date();
	Time t = new Time(0);
	@GetMapping("/hi")
	
	public String sayHello() {
		
		//return "Hello";
		HelloTest testObj = new HelloTest();
		String returnValue = testObj.Hello();
		return returnValue + " - Printed on ("+ d + ")";
	}
	@GetMapping("/hi/{name}")
	public String sayHelloToHim(@PathVariable("name")String idName, String usrID) 
	{
		return "Hello " + idName + " - Printed on ("+ t + ")";
	}
//	Post Service
	@PostMapping("/api/employees")
	public int saveEmployee (@RequestBody Employee employeeDetails) {
		
		String employeeId = employeeDetails.getEmployeeId();
		System.out.println(employeeId);
		System.out.println(employeeDetails.getAddress());
		System.out.println(employeeDetails.getAge());
		System.out.println(employeeDetails.getDateOfBirth());
		System.out.println(employeeDetails.getContactDetails());
		System.out.println(employeeDetails.getSalary());
		
		return(0);
		
	}
	@PostMapping("/api/emp")
	public List<Employee> saveEmployee1 (@RequestBody Employee employeeDetails) {
		System.out.println(employeeDetails.getContactDetails());
		return null;
		
	}
}
