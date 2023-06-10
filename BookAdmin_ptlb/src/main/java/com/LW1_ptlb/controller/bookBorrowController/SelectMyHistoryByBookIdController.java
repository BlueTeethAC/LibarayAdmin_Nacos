package com.LW1_ptlb.controller.bookBorrowController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//按照书本编号查询用户书籍借阅记录（模糊查询）
@RestController
public class SelectMyHistoryByBookIdController {

    @Autowired
    SQLService sqlService;

    @RequestMapping("/getMyHistoryByBookId/{bookId}/{userId}")
    public List<BookBorrowHistory> selectMyHistoryByBookId(@PathVariable("bookId") String bookId,@PathVariable("userId") Integer userId){

        //添加数据
        Map<String,Object> map =new HashMap();
        map.put("bookId",bookId);
        map.put("userId",userId);

        List<BookBorrowHistory> bookBorrowHistories = sqlService.selectMyHistoryByBookId(map);

        return bookBorrowHistories;
    }
}
