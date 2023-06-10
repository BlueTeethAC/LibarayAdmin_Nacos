package com.LW1_ptlb.controller.bookBorrowController.BorrowController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.bookBorrowService.GetMyHistoryByBookIdService;
import com.LW1_ptlb.service.bookBorrowService.GetMyHistoryByBorrowIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

//按照 借阅记录编号，书本编号查询用户书籍借阅记录（模糊查询） 控制
@Controller
public class GetMyHistoryByBookIdController {

    //获得 按照书本编号查询用户书籍借阅记录（模糊查询） 服务
    @Autowired
    GetMyHistoryByBookIdService getMyHistoryByBookIdService;

    @RequestMapping("/main/getMyHistoryByBookId")
    public String getMyHistoryByBookId(@RequestParam("selectBook") String bookId, HttpSession session, Model model){

        //如果输入框为空
        if (bookId.equals("")){
            return "redirect:/main/goMyBorrowHistory";
        }

        //获得用户名
        String userName = (String) session.getAttribute("loginUser");

        List<BookBorrowHistory> myHistoryByBookId = getMyHistoryByBookIdService.getMyHistoryByBookId(bookId, userName);

        model.addAttribute("selectBook",bookId);
        model.addAttribute("myBorrowHistory",myHistoryByBookId);

        return "/borrowBook/myBorrowBook";
    }
}
