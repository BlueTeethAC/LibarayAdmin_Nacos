package com.LW1_ptlb.controller;

import com.LW1_ptlb.service.LoginService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //获取 loginService 登陆服务
    @Autowired
    LoginService loginService;

    //restful 风格接收用户名和密码
    @RequestMapping(value = "/Login/{username}/{pwd}",method = RequestMethod.GET)
    public Integer loginController(@PathVariable("username") String username,@PathVariable("pwd") String pwd){
        int login = loginService.Login(username, pwd);
        return login;
        //登录方法：返回 1 登陆成功，返回 0 密码错误，返回 2 用户名不存在
    }
}
