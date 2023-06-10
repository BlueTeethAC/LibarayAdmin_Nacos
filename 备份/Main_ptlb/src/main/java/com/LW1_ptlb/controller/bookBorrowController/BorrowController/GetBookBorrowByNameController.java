package com.LW1_ptlb.controller.bookBorrowController.BorrowController;

import com.LW1_ptlb.pojo.BookCount;
import com.LW1_ptlb.service.bookAdminService.GetBookAdminByName2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//根据书名查询 书籍存量信息 控制
@Controller
public class GetBookBorrowByNameController {

    //获得 根据书名查询 书籍存量信息服务
    @Autowired
    GetBookAdminByName2Service getBookAdminByName2Service;

    @RequestMapping("/main/getBorrowBookByName")
    public String getBookAdminByName(@RequestParam("selectBook") String bookName, Model model){

        if (bookName.equals("")){//如果输入框为空
            return "redirect:/main/goBorrowBook";
        }

        List<BookCount> bookAdmin = getBookAdminByName2Service.getBookAdminByName(bookName);//执行搜索方法
        System.out.println("==========================");
        System.out.println(bookAdmin);
        model.addAttribute("selectBook",bookName);
        model.addAttribute("allBookAdmin",bookAdmin);

        return "/borrowBook/borrowBook";
    }
}
