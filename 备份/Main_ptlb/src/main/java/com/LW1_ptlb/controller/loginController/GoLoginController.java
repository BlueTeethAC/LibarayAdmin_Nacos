package com.LW1_ptlb.controller.loginController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//设置首页跳转
@Controller
public class GoLoginController {

    //直接跳转至登陆界面
    @RequestMapping("/")
    public String goLogin(){

        return "login";

    }

}
