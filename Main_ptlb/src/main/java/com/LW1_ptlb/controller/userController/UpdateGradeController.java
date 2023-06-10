package com.LW1_ptlb.controller.userController;

import com.LW1_ptlb.service.userService.UpdateGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//修改权限等级
@Controller
public class UpdateGradeController {

    //获得修改权限服务
    @Autowired
    UpdateGradeService updateGradeService;

    @RequestMapping("/main/updateGrade")
    public String updateGrade(@RequestParam("username") String username, @RequestParam("grade") Integer grade, Model model){

        Integer integer = updateGradeService.updateGrade(username, grade);//修改权限方法 返回 1 修改成功，返回 0 修改失败，返回 2 输入的权限超标

        if (integer==1){//修改成功
            System.out.println("修改成功！");
            return "redirect:/main/goUserAdmin";//重定向用户管理界面
        }else if (integer==2){//输入的权限超标，重新填写
            System.err.println("输入的权限超标！");
            model.addAttribute("username",username);//将页面的用户名保留
            model.addAttribute("grade",grade);//将页面的权限等级保留
            model.addAttribute("msg","输入的权限超标！，权限只能是 0 或 1");
            return "/top_admin/updateGrade.html";
        }else {
            System.err.println("修改失败！");
            model.addAttribute("username",username);//将页面的用户名保留
            model.addAttribute("grade",grade);//将页面的权限等级保留
            model.addAttribute("msg","修改时便，请联系管理员！");
            return "/top_admin/updateGrade.html";
        }

    }

}
