package com.LW1_ptlb.controller.bookController.bookController;

import com.LW1_ptlb.service.bookService.AddBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//添加具体书本信息控制
@Controller
public class AddBookController {

    //获得添加具体书本信息服务
    @Autowired
    AddBookService addBookService;

    //获得
    @RequestMapping("/main/addBook")
    public String addBook(String bookName, String bookId, Model model){

        Integer i = addBookService.addBook(bookName, bookId);
        //返回 1：插入成功  0：插入失败  3：已有该书本信息(bookId 重复)   4；没有查询到该书名      5：输入的图书编号不在正确范围

        //存入数据
        model.addAttribute("bookName",bookName);
        model.addAttribute("bookId",bookId);

        if (i.equals(1)){//插入成功
            return "redirect:/main/goBook";
        }else if (i.equals(4)){//插入失败
            model.addAttribute("msg","没有查询到该图书名，请输入正确的图书名！");
            return "/book/addBook";
        }else if (i.equals(3)){//书本信息重复
            model.addAttribute("msg","已有该书本信息(图书编号重复)！");
            return "/book/addBook";
        }else if(i.equals(5)){//没查询到该书名
            model.addAttribute("msg","输入的图书编号不在正确范围！");
            return "/book/addBook";
        }else {
            model.addAttribute("msg","新增失败，请联系管理员！");
            return "/book/addBook";
        }

    }

}
