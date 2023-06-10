package com.LW1_ptlb.controller.bookController;

import com.LW1_ptlb.pojo.Book;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照书本id 查询具体书本信息
@RestController
public class SelectBookByBookIdController {

    //获得 SQL语句服务
    @Autowired
    SQLService sqlService;

    //按照书本id 来查询具体书本
    @RequestMapping("/getBookInfoById/{bookId}")
    public List<Book> getBookById(@PathVariable("bookId") String bookId){

        System.out.println(bookId);

        //调用 selectBookByBookId 方法，用 bookId 查询 具体书本信息
        List<Book> book = sqlService.selectBookByBookId(bookId);

        return book;
    }
}
