package com.LW1_ptlb.controller.bookBorrowController.BorrowController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.bookBorrowService.GetMyBorrowHistoryService;
import com.LW1_ptlb.service.bookBorrowService.GetNeedBorrowHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

//按照用户名获得需要规范的书籍借阅记录
@Controller
public class GetNeedBorrowHistoryController {

    //获得 按照用户名查询需要归还的书籍借阅记录 服务
    @Autowired
    GetNeedBorrowHistoryService getNeedBorrowHistoryService;

    @RequestMapping("/main/getNeedBorrowHistory")
    public String getNeedBorrow(HttpSession session, Model model){

        //获得 用户名
        String userName = (String) session.getAttribute("loginUser");
        System.out.println(userName);

        //获得需要归还的书籍借阅记录
        List<BookBorrowHistory> needBorrow =getNeedBorrowHistoryService.getNeedBorrowHistory(userName);

        model.addAttribute("myBorrowHistory",needBorrow);

        return "/borrowBook/myBorrowBook";
    }
}
