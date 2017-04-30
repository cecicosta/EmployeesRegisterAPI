package com.access.data;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hib.entities.Employee;
import com.hib.init.HibernateUtil;

@RestController
public class EmployeesAccessController {
	 @RequestMapping(value="/employee", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	    public @ResponseBody String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 	
			Session session = HibernateUtil.getSessionFactory().openSession();
			List employees = session.createCriteria(Employee.class).list();
			Iterator<Employee> employeeIterator = employees.iterator();
			
			String responseBody = "";
			while(employeeIterator.hasNext()){
				Employee employee = employeeIterator.next();
				JSONObject json = new JSONObject();
				json.put("id", employee.getId()); 
		        json.put("name", employee.getName());
		        responseBody += json.toString();
			}

			session.close();
		return responseBody;
	 }
}
