package com.wxbc.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.wxbc.util.CacheController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AddUsernameFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = details.getUsername();
        String password = CacheController.getPassword(name);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        names.add(name);
        passwords.add(password);
        Map<String, List<String>> paramMap = new HashMap<>();
        paramMap.put("name",names);
        paramMap.put("password",passwords);
        RequestContext.getCurrentContext().setRequestQueryParams(paramMap);



        return null;
    }
}
