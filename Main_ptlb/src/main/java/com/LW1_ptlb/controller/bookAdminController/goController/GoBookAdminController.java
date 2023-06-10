package com.LW1_ptlb.controller.bookAdminController.goController;

import com.LW1_ptlb.pojo.BookCount;
import com.LW1_ptlb.service.bookAdminService.GetAllBookAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//设置图书存量管理页面跳转
@Controller
public class GoBookAdminController {

    @Autowired
    GetAllBookAdminService getAllBookAdminService;

    //直接跳转至登陆界面
    @RequestMapping("/main/goBookAdmin")
    public String goBookAdmin(Model model){

        //调用获取所有图书存量信息对象
        List<BookCount> allBookAdmin = getAllBookAdminService.getAllBookAdmin();

        //将得到的 allBookAdmin 即 图书存量信息发送到前端去
        model.addAttribute("allBookAdmin",allBookAdmin);

        return "bookAdmin/bookAdmin";

    }

}
