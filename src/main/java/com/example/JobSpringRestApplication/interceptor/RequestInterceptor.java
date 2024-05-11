package com.example.JobSpringRestApplication.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RequestInterceptor implements HandlerInterceptor {
    private final Logger _logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime); //inject new attribute 'startTime' in request header
        System.out.println("1 - pre handle.");
        System.out.println("METHOD type:" + request.getMethod());
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("Servlet PATH: " + request.getServletPath());

        if(handler instanceof HandlerMethod) {
            Class<?> controllerClass = ((HandlerMethod) handler).getBeanType();
            String methodName = ((HandlerMethod) handler).getMethod().getName();
            System.out.println("Controller name: " + controllerClass.getName());
            System.out.println("Method name:" + methodName);
        }
        if(request.getRemoteAddr().startsWith("192")) {
            response.sendRedirect("/auth-failed");
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        _logger.info("\n\n\n----------------LogInterceptor postHandle (Start)--------------------------");
        _logger.info("Request Processing ends on "+getCurrentTime());
        _logger.info("----------------LogInterceptor postHandle (End)--------------------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        if(ex != null){
            //exception handle part
            System.out.println("An error occured.");
        }
        System.out.println("3 - after completion.");
        _logger.info("\n\n\n----------------LogInterceptor after view is rendered (Start)--------------------------");

        long endTime = System.currentTimeMillis();
        long startTime=Long.parseLong(request.getAttribute("startTime")+"");
        _logger.info("Total time taken to process request (in milliseconds(ms)) "+(endTime-startTime)+" ms");
        _logger.info("----------------LogInterceptor after view is rendered (End)--------------------------");
    }

    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }
}
