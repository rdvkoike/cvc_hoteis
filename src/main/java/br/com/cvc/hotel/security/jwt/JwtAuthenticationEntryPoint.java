package br.com.cvc.hotel.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		//log.debug("Jwt authentication failed:" + authException);	
		System.out.println("Jwt authentication failed:" + authException);	
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED	, "Jwt authentication failed");

	}

}
