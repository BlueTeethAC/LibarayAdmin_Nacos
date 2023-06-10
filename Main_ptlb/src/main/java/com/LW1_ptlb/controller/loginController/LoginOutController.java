package com.LW1_ptlb.controller.loginController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//注销控制
@Controller
public class LoginOutController {

    @RequestMapping("/main/cancellation")
    public String loginOut(HttpSession session){
        session.invalidate();//移除 session
        System.out.println("已经登出！");
        return "redirect:/";
    }

}
