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

import com.authentication.jwt.JwtAuthentication;
import com.hib.entities.Employee;
import com.hib.entities.HourRegister;
import com.hib.init.DataAccessHelper;

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
			employee = DataAccessHelper.getEmployee(claims.getIssuer());
		}catch(Exception ex){
    		response.addHeader("description", ex.getMessage());
    		throw ex;
		}
		
		Date date = format.parse(request.getHeader(TIME_HEADER_PARAM));
    	HourRegister register = new HourRegister(date, employee);
    	try{
    		DataAccessHelper.submitNewRegister(register);
    	}catch(Exception ex){
			throw ex;
		}
    }
}
