package com.wxbc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseFilter extends ZuulFilter {
    protected HttpServletRequest getRequest() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        return requestContext.getRequest();
    }

    protected RequestContext getRequestContext() {
        return RequestContext.getCurrentContext();
    }

    protected HttpServletResponse getResponse() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        return requestContext.getResponse();
    }
}
