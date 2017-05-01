package com.register.api.submit;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.register.api.authentication.JwtAuthentication;
import com.register.api.commands.CreateRegisterCommand;
import com.register.api.entities.Employee;
import com.register.api.entities.HourRegister;
import com.register.api.queries.QueryEmployeeRegistersAccess;

import io.jsonwebtoken.Claims;

@RestController
public class SubmitRegisterController {
	private final String TIME_HEADER_PARAM = "time";
	JwtAuthentication jtwAuthentication = new JwtAuthentication();
	@RequestMapping(value="/register/submit", method=RequestMethod.POST)
    public @ResponseBody void submitRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {    	
    	Claims claims;
		try{
    		 claims = jtwAuthentication.authenticateRequest(request);
    	}catch(Exception ex){
    		response.addHeader("description", ex.getMessage());
    		throw ex;
    	}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Employee employee = null;
		try{
			employee = QueryEmployeeRegistersAccess.getEmployeeByCode(claims.getIssuer());
		}catch(Exception ex){
    		response.addHeader("description", ex.getMessage());
    		throw ex;
		}
		
		Date date = format.parse(request.getHeader(TIME_HEADER_PARAM));
    	HourRegister register = new HourRegister(date, employee);
    	CreateRegisterCommand cmd = new CreateRegisterCommand(register);
    	cmd.issue();
    }
}
