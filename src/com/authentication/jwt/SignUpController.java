package com.authentication.jwt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hib.entities.Employee;
import com.hib.init.DataAccessHelper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class SignUpController {
	public static String PASSWORD_HEADER_PARAM = "password";
	public static String NAME_HEADER_PARAM = "name";
	public static String ID_HEADER_PARAM = "id";
	
    @RequestMapping(value="/signup", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody void signUp(HttpServletRequest http, HttpServletResponse response) throws Exception {
    	
    	//TODO: Change to expect a base64 string encoded with a private key
    	String id = http.getHeader(ID_HEADER_PARAM);
    	String name = http.getHeader(NAME_HEADER_PARAM);
    	String password = http.getHeader(PASSWORD_HEADER_PARAM);
    	//TODO: The password must be decoded with the application's private key 
    	
    	if (id == null || id.isEmpty()) 
            throw new Exception("Missing header: " + ID_HEADER_PARAM);
        if (name == null || name.isEmpty()) 
            throw new Exception("Missing header: " + NAME_HEADER_PARAM);
        if (password == null || password.isEmpty()) 
            throw new Exception("Missing header: " + PASSWORD_HEADER_PARAM);

        Claims claims = Jwts.claims().setSubject(name);        
        String token = Jwts.builder()
          .setClaims(claims)
          .setIssuer(id)
          .signWith(SignatureAlgorithm.HS256, Base64.encodeBase64String(password.getBytes()))
        .compact();
        
        Employee employee = new Employee(id, name, Base64.encodeBase64String(password.getBytes()));
        try{
        DataAccessHelper.registerNewEmployee(employee);
        }catch (Exception ex){
        	response.addHeader("description", "Id may be already registered.");
        	throw ex;
        }
        response.addHeader("name", name);
        response.addHeader("id", employee.getId());
        response.addHeader("authorization", token);
    }

}
