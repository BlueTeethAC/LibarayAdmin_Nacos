package com.LW1_ptlb.controller.bookController.goController;

import com.LW1_ptlb.pojo.Book;
import com.LW1_ptlb.service.bookService.GetAllBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//跳转到具体书本管理页面
@Controller
public class GoBookController {

    //获得查询所有具体书本信息服务
    @Autowired
    GetAllBookService getAllBookService;

    @RequestMapping("/main/goBook")
    public String goBook(Model model){

        List<Book> allBook = getAllBookService.getAllBook();

        System.out.println(allBook);

        model.addAttribute("book",allBook);

        return "/book/book";
    }

}
