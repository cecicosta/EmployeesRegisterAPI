package com.access.data;

import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hib.entities.Employee;
import com.hib.entities.HourRegister;
import com.hib.init.HibernateUtil;

import org.json.JSONObject;


@RestController
public class EmployeeRegistersAccessController {
	 public static String ID_HEADER_PARAM = "id";
	 @RequestMapping(value="/employee/registers", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	    public @ResponseBody String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 	String id = request.getHeader(ID_HEADER_PARAM);
		 	
			Session session = HibernateUtil.getSessionFactory().openSession();
			Employee emp =  (Employee) session.get(Employee.class, id);
			Iterator<HourRegister> registerIterator = emp.getRegisters().iterator();
			
			String responseBody = "";
			while(registerIterator.hasNext()){
				HourRegister register = registerIterator.next();
				JSONObject json = new JSONObject();
				json.put("id", register.getId()); 
		        json.put("time", register.getTime().toString());
		        json.put("employeeId", register.getEmployee().getId());
		        responseBody += json.toString();
			}
			
			session.close();
		return responseBody;
	 }
}
