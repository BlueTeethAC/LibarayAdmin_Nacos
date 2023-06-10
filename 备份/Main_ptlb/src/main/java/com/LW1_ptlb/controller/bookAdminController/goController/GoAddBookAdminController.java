package com.LW1_ptlb.controller.bookAdminController.goController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//跳转到 添加图书存量信息 页面
@Controller
public class GoAddBookAdminController {

    @RequestMapping("/main/goAddBookAdmin")
    public String goAddBookAdmin(){
        return "bookAdmin/addBookAdmin";
    }

}
