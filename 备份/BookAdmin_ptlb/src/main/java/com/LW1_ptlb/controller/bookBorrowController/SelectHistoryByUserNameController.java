package com.LW1_ptlb.controller.bookBorrowController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照用户名查询该用户的借阅记录 控制
@RestController
public class SelectHistoryByUserNameController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    @RequestMapping("/getHistoryByUserName/{userName}")
    public List<BookBorrowHistory> selectHistoryByUserName(@PathVariable("userName") String userName){
        List<BookBorrowHistory> bookBorrowHistories = sqlService.selectHistoryByUserName(userName);
        return bookBorrowHistories;
    }

}
