package com.access.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRegistersAccessController {

	 @RequestMapping(value="/employee/registers", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	    public @ResponseBody String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		
		return "";
	 }
}
