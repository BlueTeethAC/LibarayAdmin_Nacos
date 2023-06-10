package com.LW1_ptlb.controller.bookController;

import com.LW1_ptlb.pojo.Book;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照书名查询当前可以借阅的书籍 控制
@RestController
public class SelectCanBorrowBookByNameController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    @RequestMapping("/getCanBorrowByName/{bookName}")
    public List<Book> selectCanBorrowBookByName(@PathVariable("bookName") String bookName){
        List<Book> books = sqlService.selectCanBorrowBookByName(bookName);
        return books;
    }

}
