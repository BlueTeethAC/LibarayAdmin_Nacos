package com.LW1_ptlb.controller.bookBorrowController.goController;

import com.LW1_ptlb.pojo.Book;
import com.LW1_ptlb.service.bookBorrowService.GetCanBorrowBookByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//跳转到 借阅具体书本页面控制
@Controller
public class GoBorrowBookByNameController {

    //获得 根据书名查询可借阅的具体书本信息服务
    @Autowired
    GetCanBorrowBookByNameService getCanBorrowBookByNameService;

    @RequestMapping("/main/goBookBorrowByName/{bookName}")
    public String goBorrowBookByName(@PathVariable("bookName") String bookName, Model model){

        List<Book> canBorrowBook = getCanBorrowBookByNameService.getCanBorrowBook(bookName);
        model.addAttribute("canBorrowBook",canBorrowBook);

        return "/borrowBook/borrowBookByName";
    }
}
