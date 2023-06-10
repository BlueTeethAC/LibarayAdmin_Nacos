package com.LW1_ptlb.controller.bookBorrowController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照用户名 查询该用户未归还的 借阅记录
@RestController
public class SelectNeedReturnByUserNameController {

    //获得 SQL 语句 服务
    @Autowired
    SQLService sqlService;

    @RequestMapping("/getNeedReturnBook/{userName}")
    public List<BookBorrowHistory> selectBook(@PathVariable("userName") String userName){
        List<BookBorrowHistory> bookBorrowHistories = sqlService.selectNeedReturnHistory(userName);
        return bookBorrowHistories;
    }

}
