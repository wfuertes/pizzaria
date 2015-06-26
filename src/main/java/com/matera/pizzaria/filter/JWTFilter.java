package com.matera.pizzaria.filter;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.util.Assert;
import org.springframework.web.filter.GenericFilterBean;

import com.matera.pizzaria.exception.InvalidTokenException;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;

public class JWTFilter extends GenericFilterBean {

//	private static final String X_AUTH_TOKEN = "X-Auth-Token";

//	private final UserDetailsService userService;
//
//	public JWTFilter(UserDetailsService userService) {
//		this.userService = userService;
//	}
	
	private AuthenticationEntryPoint entryPoint;
	
	@Autowired
	@Qualifier("authenticationManager")	
    private AuthenticationManager authenticationManager;
    
    public JWTFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint entryPoint) {
        this.authenticationManager = authenticationManager;
        this.entryPoint = entryPoint;
    }
    
    @Override
    public void afterPropertiesSet() throws ServletException {
        Assert.notNull(authenticationManager);
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        try {
            String stringToken = req.getHeader("Authorization");
//            if (stringToken == null) {
//                throw new InsufficientAuthenticationException("Authorization header not found");
//            }
            //	If there's not credentials return...
            if (stringToken == null) {
                chain.doFilter(request, response);
                return;
            }
            
            // remove schema from token
            String authorizationSchema = "Bearer";
            if (stringToken.indexOf(authorizationSchema) == -1) {
                throw new InsufficientAuthenticationException("Authorization schema not found");
            }
            stringToken = stringToken.substring(authorizationSchema.length()).trim();
            
            try {
                JWT jwt = JWTParser.parse(stringToken);
                JWTToken token = new JWTToken(jwt);
            
                Authentication auth = authenticationManager.authenticate(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
                chain.doFilter(request, response);
            } catch (ParseException e) {
                throw new InvalidTokenException("Invalid token");
            }
        } catch (AuthenticationException e) {
        	e.printStackTrace();
            SecurityContextHolder.clearContext();
            if (entryPoint != null) {
                entryPoint.commence(req, res, e);
            }
        }    
    }

//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response,
//			FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest httpRequest = this.getAsHttpRequest(request);
//
//		String authToken = this.extractAuthTokenFromRequest(httpRequest);
//		String userName = TokenUtils.getUserNameFromToken(authToken);
//
//		if (userName != null) {
//
//			UserDetails userDetails = this.userService
//					.loadUserByUsername(userName);
//
//			if (TokenUtils.validateToken(authToken, userDetails)) {
//
//				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//						userDetails, null, userDetails.getAuthorities());
//				authentication.setDetails(new WebAuthenticationDetailsSource()
//						.buildDetails(httpRequest));
//				SecurityContextHolder.getContext().setAuthentication(
//						authentication);
//			}
//		}
//
//		chain.doFilter(request, response);
//	}
//
//	private HttpServletRequest getAsHttpRequest(ServletRequest request) {
//		if (!(request instanceof HttpServletRequest)) {
//			throw new RuntimeException("Expecting an HTTP request");
//		}
//
//		return (HttpServletRequest) request;
//	}
//
//	private String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {
//		/* Get token from header */
//		String authToken = httpRequest.getHeader(X_AUTH_TOKEN);
//
//		/* If token not found get it from request parameter */
//		if (authToken == null) {
//			authToken = httpRequest.getParameter("token");
//		}
//
//		return authToken;
//	}
}
