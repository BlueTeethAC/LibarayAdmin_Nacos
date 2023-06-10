package com.LW1_ptlb.controller.bookBorrowController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照书本编号查询查询书籍借阅记录（模糊查询）
@RestController
public class SelectHistoryByBookIdController {

    @Autowired
    SQLService sqlService;

    @RequestMapping("/getHistoryByBookId/{bookId}")
    public List<BookBorrowHistory> selectHistoryByBookId(@PathVariable("bookId") String bookId){

        List<BookBorrowHistory> bookBorrowHistories = sqlService.selectHistoryByBookId(bookId);

        return bookBorrowHistories;
    }
}
