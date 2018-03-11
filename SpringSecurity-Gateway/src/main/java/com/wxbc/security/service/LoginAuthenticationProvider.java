package com.wxbc.security.service;

import com.wxbc.util.CacheController;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by fengxinhe on 2017/8/23.
 */
public class LoginAuthenticationProvider extends DaoAuthenticationProvider {


    @Override
    public boolean supports(Class<?> authentication) {
        boolean isAssign = UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
        return isAssign;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken
            authentication) throws AuthenticationException {

        String username = userDetails.getUsername();  //loadUserByUsername
        String password = userDetails.getPassword();

        String pubKeySigned = authentication.getPrincipal().toString();
        try {
            CacheController.putNameAndPassword(username, password);
        } catch (Exception e) {
            throw new BadCredentialsException("tag or addressKey Exception");
        }

    }
}