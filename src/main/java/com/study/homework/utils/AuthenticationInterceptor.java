package com.study.homework.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
//        查看请求中是否存在token，如果不存在直接跳转到登陆页面
        String token = tokenUtil.getToken(request);
//        System.out.println(token);
        if (StringUtils.isEmpty(token)) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}

