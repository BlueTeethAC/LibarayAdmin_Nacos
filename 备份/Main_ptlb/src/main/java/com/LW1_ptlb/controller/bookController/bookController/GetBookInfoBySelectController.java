package com.LW1_ptlb.controller.bookController.bookController;

import com.LW1_ptlb.pojo.Book;
import com.LW1_ptlb.service.bookService.GetAllBookService;
import com.LW1_ptlb.service.bookService.GetBookByIdService;
import com.LW1_ptlb.service.bookService.GetBookByNameService;
import com.LW1_ptlb.service.bookService.GetBookBySelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

//按照书名查获得id询对应的具体书本信息
@Controller
public class GetBookInfoBySelectController {

    //获得 通过书名查询具体书本信息服务
    @Autowired
    GetBookBySelectService getBookBySelectService;

    //获得 查询所有具体书本信息服务
    @Autowired
    GetAllBookService getAllBookService;

    @RequestMapping("/main/getBookBySelect")
    public String getBookByName(@RequestParam("selectBook") String selectBook, Model model){

        System.err.println("=========================");
        System.err.println(selectBook);
        System.err.println("=========================");

        List<Book> book = new LinkedList();

        if (selectBook.equals("")){//搜索输入框为空
            book = getAllBookService.getAllBook();
        }else {//搜索输入框有数据
            book = getBookBySelectService.getBookBySelect(selectBook);//执行 根据书名或者id查询具体书本方法
            model.addAttribute("selectBook",selectBook);//将搜索框中的信息一同返回
        }

        model.addAttribute("book",book);//将查询到的信息返回给前端

        return "/book/book";

    }
}
