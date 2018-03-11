package com.wxbc.security.service;

import com.wxbc.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by fengxinhe on 2017/8/23.
 */
public class LoginProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private String USERNAME = "name";
    private String PASSWORD = "password";

    @Autowired
    private SessionRegistry sessionRegistry;

    public LoginProcessingFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
            AuthenticationException, IOException, ServletException {
        Object username = null;
        Object password = null;
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            for (String s : parameterMap.keySet()) {
                System.out.println(s);
                System.out.println(parameterMap.get(s));
            }
            Map values = CommonUtil.getRequestParam(request);
            username = values.get(USERNAME);
            password = values.get(PASSWORD);

        } catch (Exception e) {
            throw new BadCredentialsException("Parameter exception");
        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username ,password);
        sessionRegistry.registerNewSession(request.getSession().getId(), username);

        return this.getAuthenticationManager().authenticate(token);
    }

}
