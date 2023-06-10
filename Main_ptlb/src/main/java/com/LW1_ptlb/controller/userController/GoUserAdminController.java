package com.LW1_ptlb.controller.userController;

import com.LW1_ptlb.pojo.User;
import com.LW1_ptlb.service.userService.GetAllUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//跳转到 userAdmin，用户权限管理页面
@Controller
public class GoUserAdminController {

    @Autowired
    GetAllUserService getAllUserService;

    @RequestMapping("/main/goUserAdmin")
    public String goUserAmin(Model model){

        //获得所有用户
        List<User> allUser = getAllUserService.getAllUser();

        model.addAttribute("allUser",allUser);

        //跳转到用户管理页面
        return "top_admin/userAdmin.html";

    }

}
