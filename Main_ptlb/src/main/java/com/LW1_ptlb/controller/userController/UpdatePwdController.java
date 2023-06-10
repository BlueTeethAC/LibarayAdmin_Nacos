package com.LW1_ptlb.controller.userController;

import com.LW1_ptlb.service.userService.UpdatePwdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//跳转到修改密码界面
@Controller
public class UpdatePwdController {

    @Autowired
    UpdatePwdService updatePwdService;

    @RequestMapping("/main/updatePwd")
    public String updatePwd(@RequestParam("grade") Integer grade,@RequestParam("username") String username,@RequestParam("password") String password, @RequestParam("newPassword") String newPassword, @RequestParam("newPasswordAgain") String newPasswordAgain, Model model){

        //如果密码与确认密码一致
        if (newPassword.equals(newPasswordAgain)){

            Integer i = updatePwdService.updatePwd(username,password,newPassword);//修改密码，返回 1，密码修改成功，返回 0，密码修改失败

            if (i.equals(1)){

                System.out.println("密码修改成功！");

                if (grade==2){//最高管理员跳转

                    return "redirect:/topAdmin";//重定向到最高管理员主页

                }else if (grade==1){//管理员跳转

                    return "redirect:/admin";//重定向到管理员主页

                }else{//普通用户跳转

                    return "redirect:/user";//重定向到用户主页

                }
            }else if (i.equals(2)){//数据库中的密码与输入的原密码不一致
                System.err.println("原密码错误！");
                model.addAttribute("msg","原密码错误！");
                return "updatepwd/updatepwd";//确认密码与新密码不一致时，跳回修改密码界面
            }else {
                System.err.println("密码修改失败，请联系管理员!");
                model.addAttribute("msg","密码修改失败，请联系管理员!");
                return "updatepwd/updatepwd";//确认密码与新密码不一致时，跳回修改密码界面
            }

        }else {//如果新密码与确认密码不一致
            System.err.println("确认密码与新密码不同!");
            model.addAttribute("msg","确认密码与新密码不同!");
            return "updatepwd/updatepwd";//确认密码与新密码不一致时，跳回修改密码界面
        }

    }

}
