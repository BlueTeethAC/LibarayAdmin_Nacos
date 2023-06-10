package com.LW1_ptlb.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//编写拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //登陆成功之后，应该有用户的 session
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser==null){
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/").forward(request,response);//设置重定向页面
            //此处 /，会自动跳转到 login.html，可以直接看 loginController 下的 GoLoginController
            return false;
        }else{
            return true;
        }

    }
}
