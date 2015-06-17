/*
 * Copyright 2015, Charter Communications,  All rights reserved.
 */
package com.matera.pizzaria.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matera.pizzaria.dto.SessionInfo;
import com.matera.pizzaria.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


/**
 *
 *
 * @author wbatista
 */
@Component
public class PizzariaAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession(); 
        User user = (User) authentication.getPrincipal();
        
        SessionInfo info = new SessionInfo();
        info.setId(session.getId());
        info.setUser(user);
        
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(200);
        Cookie cookie = new Cookie("JSESSIONID",  session.getId());
        cookie.setDomain("pizzaria.aqui.net");
        response.addCookie(cookie);
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(mapper.writeValueAsString(info));
    }
}
