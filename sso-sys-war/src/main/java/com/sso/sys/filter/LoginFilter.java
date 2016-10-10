package com.sso.sys.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author lijianhua 权限拦截
 */
public class LoginFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    	log.info("enter doFilter:{}",chain);
        HttpServletRequest servletRequest = (HttpServletRequest) request;

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        chain.doFilter(servletRequest, httpServletResponse);
    }
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }


    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }
}
