package com.example.sweater.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectInterseptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null) {

            String args = request.getQueryString() != null ? request.getQueryString() : "";
            String url = request.getQueryString().toString() + "?" + args;
            response.setHeader("Turbolinks-Location", url);
        }
    }
}
