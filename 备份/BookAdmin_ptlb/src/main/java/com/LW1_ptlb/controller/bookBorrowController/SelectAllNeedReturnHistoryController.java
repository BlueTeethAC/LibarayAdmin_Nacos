package com.LW1_ptlb.controller.bookBorrowController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//查询所有未归还的 借阅记录
@RestController
public class SelectAllNeedReturnHistoryController {

    //获得 SQL 语句服务
    @Autowired
    SQLService sqlService;

    @RequestMapping("/getAllNeedReturnHistory")
    public List<BookBorrowHistory> selectAllNeedReturnHistory(){
        List<BookBorrowHistory> bookBorrowHistories = sqlService.selectAllNeedReturnHistory();
        return bookBorrowHistories;
    }

}
