package com.wxbc.filter;

import com.wxbc.redis.RedisService;
import com.wxbc.util.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserAuthorzationFilter extends BaseFilter {

    @Autowired
    private RedisService redisService;

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
        HttpServletRequest request = this.getRequest();
        String requestURI = request.getRequestURI();
        if (!requestURI.contains("/login")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object run() {
        String login_token = CookieUtils.getCookieValue(getRequest(), "LOGIN_TOKEN");
        if (!StringUtils.isEmpty(login_token) ) {
            String userValue = redisService.hget("LOGIN_TOKEN-" + login_token, "active");
            if (StringUtils.isEmpty(userValue)){
                getRequestContext().setSendZuulResponse(false);
                HttpServletResponse response = getRequestContext().getResponse();
                response.setContentType("text/html;charset=UTF-8");
                CookieUtils.deleteCookie(getRequest(),response,"LOGIN_TOKEN");
                getRequestContext().setResponseStatusCode(200);
                getRequestContext().setResponseBody("错误的token");
            }
            return null;
        } else {
            getRequestContext().setSendZuulResponse(false);
            HttpServletResponse response = getRequestContext().getResponse();
            response.setContentType("text/html;charset=UTF-8");
            getRequestContext().setResponseStatusCode(200);
            getRequestContext().setResponseBody("登陆超时");
        }
        return null;

    }
}
