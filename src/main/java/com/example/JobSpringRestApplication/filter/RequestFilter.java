package com.example.JobSpringRestApplication.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
@Slf4j
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LoggingFilter init method");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        final HttpServletResponse httpRes = (HttpServletResponse) servletResponse;
        final String authorization  = httpRequest.getHeader("authorization");
        log.info("Authorization : {}", authorization);
        if(authorization != null){
            log.info("LoggingFilter doFilter method passed");
            // Continue with the filter chain
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            log.info("LoggingFilter doFilter method failed");
            filterChain.doFilter(servletRequest, servletResponse);
            // httpRes.sendRedirect("/auth-failed"); // Redirect to unauthorized page
        }

    }

    @Override
    public void destroy() {
        log.info("LoggingFilter destroy method");
        Filter.super.destroy();
    }
}
