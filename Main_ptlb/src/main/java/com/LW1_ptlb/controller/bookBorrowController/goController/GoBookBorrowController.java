package com.LW1_ptlb.controller.bookBorrowController.goController;

import com.LW1_ptlb.pojo.BookCount;
import com.LW1_ptlb.service.bookAdminService.GetAllBookAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//跳转到 书籍借阅界面
@Controller
public class GoBookBorrowController {

    @Autowired
    GetAllBookAdminService getAllBookAdminService;

    //跳转到书籍借阅界面
    @RequestMapping("/main/goBorrowBook")
    public String goBookBorrow(Model model){

        //调用获取所有图书存量信息对象
        List<BookCount> allBookAdmin = getAllBookAdminService.getAllBookAdmin();

        //将得到的 allBookAdmin 即 图书存量信息发送到前端去
        model.addAttribute("allBookAdmin",allBookAdmin);

        return "/borrowBook/borrowBook";
    }

}
