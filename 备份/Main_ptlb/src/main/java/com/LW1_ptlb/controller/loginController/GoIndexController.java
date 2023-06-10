package com.LW1_ptlb.controller.loginController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//负责各级别用户的主页跳转
@Controller
public class GoIndexController {

    @RequestMapping("/main/returnIndex")
    public String goIndex(HttpSession session){

        Integer i= (Integer) session.getAttribute("grade");
        System.out.println("权限等级为："+i);

        if (i.equals(0)){
            return "/user/userIndex";
        }else if (i.equals(1)){
            return "/admin/adminIndex";
        }else {
            return "/top_admin/top_adminIndex";
        }
    }

}
