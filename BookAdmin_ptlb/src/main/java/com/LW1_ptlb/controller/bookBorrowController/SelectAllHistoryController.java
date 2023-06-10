package com.LW1_ptlb.controller.bookBorrowController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//查询所有书本借阅记录
@RestController
public class SelectAllHistoryController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    @RequestMapping("/getAllHistory")
    public List<BookBorrowHistory> selectAllHistory(){

        //调用查询所有记录的方法
        List<BookBorrowHistory> bookBorrowHistories = sqlService.selectAllHistory();

        return bookBorrowHistories;
    }

}
