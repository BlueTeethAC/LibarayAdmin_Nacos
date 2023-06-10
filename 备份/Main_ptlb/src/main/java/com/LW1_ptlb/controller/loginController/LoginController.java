package com.LW1_ptlb.controller.loginController;

import com.LW1_ptlb.service.userService.GetGradeService;
import com.LW1_ptlb.service.userService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

//登陆服务控制
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    GetGradeService getGradeService;

    //@ResponseBody//让链接不走视图解析器
    //@RequestMapping("/main/login/{username}/{password}")
    @RequestMapping("/main/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model,HttpSession session){
    //public void login(@PathVariable("username") String username,@PathVariable("password") String password){
        //调用 登陆服务 loginService.login
        Integer login = loginService.login(username, password);

        System.out.println("===================login==================");
        System.out.println(username+"//////////"+password);
        System.out.println("登陆！");
        System.out.println("===================login==================");

        //返回 1 登陆成功，返回 0 密码错误，返回 2 用户名不存在

        if (login==1){//为 1，登陆成功

            //如果登陆成功，就有 session 了
            session.setAttribute("loginUser",username);

            Integer grade = getGradeService.getGrade(username);//获得权限等级

            //将权限等级添加到 session 里面去
            session.setAttribute("grade",grade);


            if (grade==2){//最高管理员跳转

                return "redirect:/topAdmin";//重定向到最高管理员主页

            }else if (grade==1){//管理员跳转

                return "redirect:/admin";//重定向到管理员主页

            }else{//普通用户跳转

                return "redirect:/user";//重定向到用户主页

            }

        }else if(login==0){//密码错误的情况

            model.addAttribute("msg","密码错误！");

            return "login.html";//返回到登录页面

        }else{//用户名不存在的情况

            model.addAttribute("msg","用户名不存在！");

            return "login.html";//返回到登陆页面

        }
    }

}
