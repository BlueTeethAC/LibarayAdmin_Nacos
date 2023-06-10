package com.LW1_ptlb.controller.bookBorrowController.goController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//跳转到归还书籍页面 控制
@Controller
public class GoReturnBookController {

    @RequestMapping("/main/goReturnBook/{returnStatus}/{borrowId}/{bookId}")
    public String goReturnBook(@PathVariable("returnStatus") Integer returnStatus, @PathVariable("borrowId") Integer borrowId, @PathVariable("bookId") String bookId, Model model){

        //添加数据
        model.addAttribute("returnStatus",returnStatus);
        model.addAttribute("borrowId",borrowId);
        model.addAttribute("bookId",bookId);

        System.out.println(returnStatus);

        return "/borrowBook/returnBook";
    }
}
