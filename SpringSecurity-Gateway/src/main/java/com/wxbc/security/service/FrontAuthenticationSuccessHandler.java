package com.wxbc.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fengxinhe on 2017/8/23.
 */

public class FrontAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {


    public FrontAuthenticationSuccessHandler(String defaultTargetUrl) {
        super(defaultTargetUrl);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication
            authentication) throws IOException, ServletException {

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
