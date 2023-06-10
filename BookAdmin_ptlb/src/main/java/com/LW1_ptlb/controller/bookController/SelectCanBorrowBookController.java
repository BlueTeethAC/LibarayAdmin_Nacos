package com.LW1_ptlb.controller.bookController;

import com.LW1_ptlb.pojo.Book;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//查询当前所有可以借阅的书籍
@RestController
public class SelectCanBorrowBookController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    @RequestMapping("/getCanBorrowBook")
    public List<Book> selectCanBorrowBook(){
        List<Book> books = sqlService.selectCanBorrowBook();
        return books;
    }

}
