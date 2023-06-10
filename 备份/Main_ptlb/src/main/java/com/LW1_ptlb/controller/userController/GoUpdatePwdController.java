package com.LW1_ptlb.controller.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//跳转到密码修改页面
@Controller
public class GoUpdatePwdController {

    @RequestMapping("/main/goUpdatePwd")
    public String goUpdatePwd(){

        //跳转到密码修改页面
        return "/updatepwd/updatepwd";

    }

}
