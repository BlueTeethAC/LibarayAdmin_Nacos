package com.LW1_ptlb.controller.bookBorrowController.goController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.bookBorrowService.GetAllBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//跳转到 借阅书籍归还界面（管理员） 控制
@Controller
public class GoBorrowBookAdminController {

    //获得 查询所有借阅记录 服务
    @Autowired
    GetAllBorrowService getAllBorrowService;

    @RequestMapping("/main/goBorrowBookAdmin")
    public String goBorrowAdmin(Model model){

        List<BookBorrowHistory> allBorrow = getAllBorrowService.getAllBorrow();

        model.addAttribute("allBorrow",allBorrow);

        return "/borrowBook/borrowBookAdmin";
    }
}
