package com.access.data;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hib.entities.HourRegister;
import com.hib.init.DataAccessHelper;

@RestController
public class EmployeeRegistersAccessController {
public static String ID_HEADER_PARAM = "id";
@RequestMapping(value="/employee/registers", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getHeader(ID_HEADER_PARAM);
		
		Iterator<HourRegister> registerIterator = null;
		try{
			registerIterator = DataAccessHelper.getEmployeeRegisters(id).iterator();
		}catch(Exception ex){
			response.addHeader("description", ex.getMessage());
			throw ex;
		}
		
		String responseBody = "[";
		while(registerIterator.hasNext()){
			HourRegister register = registerIterator.next();
			responseBody += register.toJson().toString();
			responseBody += registerIterator.hasNext()? ",": "]";
		}
		
		return responseBody;	
	}
}
