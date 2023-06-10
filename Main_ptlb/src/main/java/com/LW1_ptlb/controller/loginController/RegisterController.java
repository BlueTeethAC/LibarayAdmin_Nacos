package com.LW1_ptlb.controller.loginController;

import com.LW1_ptlb.service.userService.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//注册服务控制
@Controller
public class RegisterController {

    @Autowired
    RegisterService registerService;//获得 注册 服务 RegisterService

    //负责注册
    @RequestMapping("/main/registered")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("passwordAgain") String passwordAgain, Model model){

        if (password.equals(passwordAgain)){//如果密码和确认密码相同

            Integer i = registerService.register(username, password);//返回 1 注册成功，返回 0 插注册失败

            if (i==1){//注册成功时
                System.err.println("注册成功！");
                model.addAttribute("msg","注册成功，请登录！");
                return "redirect:/";//注册成功跳转到登陆页面
            }else if(i==2){
                System.err.println("用户名已经存在");
                model.addAttribute("msg","用户名已经存在，请换一个用户名！");
                return "/registered/registered";//注册失败，重新跳转注册页面，并报错
            }else {//注册失败时
                System.err.println("注册失败，请联系管理员！");
                model.addAttribute("msg","注册失败，请联系管理员！");
                return "/registered/registered";//注册失败，重新跳转注册页面，并报错
            }

        }else {
            //确认密码和密码不一致时
            System.err.println("确认密码与密码不一致，请重试！");
            model.addAttribute("msg","确认密码与密码不一致，请重试！");
            return "/registered/registered";//密码不一致，重新跳转注册页面，并且提示用户 密码不一致

        }

    }

}
