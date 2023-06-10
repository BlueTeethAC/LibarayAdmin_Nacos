package com.LW1_ptlb.controller.userController;

import com.LW1_ptlb.pojo.User;
import com.LW1_ptlb.service.userService.GetUserByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//根据 用户名 查询用户（模糊查询） 控制
@Controller
public class GetUserByNameController {

    //获得   根据用户名 查询用户（模糊查询） 服务
    @Autowired
    GetUserByNameService getUserByNameService;

    @RequestMapping("/main/getUserByName")
    public String getUserByName(@RequestParam("selectUserName") String userName, Model model){

        if (userName.equals("")){//如果输入框为空
            return "redirect:/main/goUserAdmin";
        }

        //根据用户名 查询用户（模糊查询）
        List<User> user = getUserByNameService.getUserByName(userName);

        model.addAttribute("selectUserName",userName);
        model.addAttribute("allUser",user);

        return "/top_admin/userAdmin.html";
    }

}
