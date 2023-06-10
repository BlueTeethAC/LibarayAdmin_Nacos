package com.LW1_ptlb.controller.loginController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//跳转到 注册页面
@Controller
public class GoRegisterController {

    //接收请求
    @RequestMapping("/main/goRegister")
    public String goRegister(){

        return "registered/registered";//跳转到注册页面

    }

}
