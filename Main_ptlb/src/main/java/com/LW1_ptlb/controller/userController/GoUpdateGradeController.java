package com.LW1_ptlb.controller.userController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//跳转到管理用户权限界面
@Controller
public class GoUpdateGradeController {

    //接收传来的用户名和权限等级
    @RequestMapping("/main/updateGradeByName/{username}/{grade}")
    public String goUpdateGrade(@PathVariable("username") String username, @PathVariable("grade") Integer grade, Model model){

        //把被修改者的用户名传入 model
        model.addAttribute("username",username);
        //把被修改者当前的权限等级传入 model
        model.addAttribute("grade",grade);

        //携带数据跳转到权限修改页面
        return "/top_admin/updateGrade.html";

    }

}
