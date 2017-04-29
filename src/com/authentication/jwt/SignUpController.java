package com.authentication.jwt;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import com.hib.entities.Employee;
import com.hib.init.HibernateUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class SignUpController {
	public static String PASSWORD_HEADER_PARAM = "password";
	public static String NAME_HEADER_PARAM = "username";
	
    @RequestMapping(value="/signup", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody String login(HttpServletRequest http) throws Exception {
    	
    	//TODO: Change to expect a base64 string encoded with a private key
    	String name = http.getHeader(NAME_HEADER_PARAM);
    	String password = http.getHeader(PASSWORD_HEADER_PARAM);
    	//TODO: The password must be decoded with the application's private key 
    	
        if (name.isEmpty()) 
            throw new IllegalArgumentException("Cannot create JWT Token without username");
        if (password.isEmpty()) 
            throw new IllegalArgumentException("Cannot create JWT Token without password");

   
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEncryptedPass(Base64Coder.encodeString(password));
        session.save(employee);
        
        session.getTransaction().commit();

        Claims claims = Jwts.claims().setSubject(name);
        
        String token = Jwts.builder()
          .setClaims(claims)
          .setIssuer("create user id")
          .signWith(SignatureAlgorithm.HS256, Base64Coder.encodeString(password))
        .compact();

        JSONObject json = new JSONObject();
        json.put("id", employee.getId());
        json.put("name", name);
        json.put("authorization", token);
        
        return json.toString();
    }

}
