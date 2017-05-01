package com.register.api.access.data;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.register.api.entities.Employee;
import com.register.api.queries.QueryEmployeeRegistersAccess;

@RestController
public class EmployeesAccessController {
	@RequestMapping(value="/employee", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody String employees(HttpServletRequest request, HttpServletResponse response) throws Exception {
	 	
	Iterator<Employee> employeeIterator = QueryEmployeeRegistersAccess.getEmployees().iterator();
	
	String responseBody = "[";
	while(employeeIterator.hasNext()){
		Employee employee = employeeIterator.next();;
		responseBody += employee.toJson();
		responseBody += employeeIterator.hasNext()? ",": "]";
	}
		return responseBody;
	}
}
