package com.LW1_ptlb.controller.bookBorrowController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照记录编号查询书籍借阅记录
@RestController
public class SelectHistoryByBorrowIdController {

    @Autowired
    SQLService sqlService;

    @RequestMapping("/getHistoryByBorrowId/{borrowId}")
    public List<BookBorrowHistory> selectHistoryByBorrowId(@PathVariable("borrowId") Integer borrowId){
        List<BookBorrowHistory> bookBorrowHistories = sqlService.selectHistoryByBorrowId(borrowId);
        return bookBorrowHistories;
    }
}
