package com.authentication.jwt;

import javax.servlet.http.HttpServletRequest;

import com.hib.init.DataAccessHelper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtAuthentication {
	public static String HEADER_PREFIX = "Bearer ";
	public static String JWT_TOKEN_HEADER_PARAM = "X-Authorization";
	public static String ID_HEADER_PARAM = "id";
	private Jws<Claims> claims;
	private String key;
	
    public Claims authenticateRequest(HttpServletRequest request) throws Exception {
    	String id = request.getHeader(ID_HEADER_PARAM);
    	String value = request.getHeader(JWT_TOKEN_HEADER_PARAM);
    	
    	if (id == null || id.isEmpty()) 
            throw new Exception("Missing header: " + ID_HEADER_PARAM);
        if (value == null || value.isEmpty()) 
            throw new Exception("Missing header:" + JWT_TOKEN_HEADER_PARAM);
   
        String token = value.substring(HEADER_PREFIX.length(), value.length());
        try {
        	key = DataAccessHelper.getEmployeeEncryptedPass(id);
        	claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
            throw new Exception("Invalid JWT token: ", ex);
        } catch (Exception ex){
        	throw ex;
        }
        return claims.getBody();
    }
}
