package com.authentication.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
public class LoginController {
	public static String HEADER_PREFIX = "Bearer ";
	public static String JWT_TOKEN_HEADER_PARAM = "X-Authorization";
	
    @RequestMapping(value="/login", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody String login(HttpServletRequest http) throws Exception {
    	String value = http.getHeader(JWT_TOKEN_HEADER_PARAM);
    	String token = value.substring(HEADER_PREFIX.length(), value.length());
    	
    	Jws<Claims> claims = null;
        try {
        	//Base64 encoded secret MTIzNDU2 (123456)
            claims = Jwts.parser().setSigningKey("MTIzNDU2").parseClaimsJws(token);
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
            throw new Exception("Invalid JWT token: ", ex);
        } 
        return claims.getBody().getIssuer();
    }

    
}
