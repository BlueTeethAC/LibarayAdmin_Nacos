package com.LW1_ptlb.controller.bookBorrowController.goController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.bookBorrowService.GetMyBorrowHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

//跳转到 个人书籍 借阅记录 控制
@Controller
public class GoMyBorrowController {

    //获得 GetMyBorrowHistoryService 服务
    @Autowired
    GetMyBorrowHistoryService getMyBorrowHistoryService;

    @RequestMapping("/main/goMyBorrowHistory")
    public String goMyBorrowHistory(HttpSession session, Model model){

        //获得用户名
        String userName = (String) session.getAttribute("loginUser");

        //获得 个人书籍借阅记录
        List<BookBorrowHistory> myBorrowHistory = getMyBorrowHistoryService.getMyBorrowHistory(userName);

        //将数据发送给前端
        model.addAttribute("myBorrowHistory",myBorrowHistory);

        return "/borrowBook/myBorrowBook";
    }
}
