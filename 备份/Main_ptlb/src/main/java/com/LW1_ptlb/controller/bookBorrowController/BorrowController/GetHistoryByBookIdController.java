package com.LW1_ptlb.controller.bookBorrowController.BorrowController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.bookBorrowService.GetHistoryByBookIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//按照书本编号查询查询书籍借阅记录（模糊查询）控制
@Controller
public class GetHistoryByBookIdController {

    //获得 按照书本编号查询查询书籍借阅记录（模糊查询） 服务
    @Autowired
    GetHistoryByBookIdService getHistoryByBookIdService;

    @RequestMapping("/main/getHistoryByBookId")
    public String getHistoryByBookId(@RequestParam("selectBook") String bookId, Model model){

        //如果输入框的数据为空
        if (bookId.equals("")){
            return "redirect:/main/goBorrowBookAdmin";
        }

        List<BookBorrowHistory> historyByBookId = getHistoryByBookIdService.getHistoryByBookId(bookId);

        model.addAttribute("selectBook",bookId);
        model.addAttribute("allBorrow",historyByBookId);

        return "/borrowBook/borrowBookAdmin";
    }
}
