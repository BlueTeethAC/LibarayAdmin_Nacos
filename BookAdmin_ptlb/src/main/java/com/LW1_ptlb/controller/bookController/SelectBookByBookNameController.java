package com.LW1_ptlb.controller.bookController;

import com.LW1_ptlb.pojo.Book;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照书名查询对应的所有书本信息
@RestController
public class SelectBookByBookNameController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //通过用户名来查询书本信息（不是书名哦）
    @RequestMapping("/getAllBookInfoByName/{bookName}")
    public List<Book> getBookByName(@PathVariable("bookName") String bookName){
        List<Book> books = sqlService.selectAllBookByBookName(bookName);
        return books;
    }

}
