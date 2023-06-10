package com.LW1_ptlb.controller.loginController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//负责各级别用户的主页跳转
@Controller
public class IndexController {

    //普通用户跳转至首页
    @RequestMapping("/user")
    public String goUserIndex(){
        return "/user/userIndex";
    }

    //管理员跳转至管理员首页
    @RequestMapping("/admin")
    public String goAdminIndex(){
        return "/admin/adminIndex";
    }

    //最高管理员跳转至最高管理员首页
    @RequestMapping("/topAdmin")
    public String goTopAdmin(){
        return "/top_admin/top_adminIndex";
    }

}
