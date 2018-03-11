package com.wxbc.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;

/**
 * Created by administrator on 17-9-8.
 */

public class CustomSessionControlStrategy extends ConcurrentSessionControlAuthenticationStrategy {

    public CustomSessionControlStrategy(SessionRegistry sessionRegistry) {
        super(sessionRegistry);
    }

    protected int getMaximumSessionsForThisUser(Authentication authentication) {
        if (authentication.getAuthorities() != null) {
            if (authentication.getAuthorities().size() == 1) {
                for (GrantedAuthority simpleGrantedAuthority : authentication.getAuthorities())
                    if(simpleGrantedAuthority.getAuthority().equals("ROLE_ADMIN")){
                    return Integer.MAX_VALUE;
                }

            }
        }
        return super.getMaximumSessionsForThisUser(authentication);
    }
}
