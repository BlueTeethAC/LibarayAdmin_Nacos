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

//按照记录编号查询用户书籍借阅记录
@RestController
public class SelectMyHistoryByBorrowIdController {

    @Autowired
    SQLService sqlService;

    @RequestMapping("/getMyHistoryByBorrowId/{borrowId}/{userId}")
    public List<BookBorrowHistory> selectMyHistoryByBorrowId(@PathVariable("borrowId") Integer borrowId,@PathVariable("userId") Integer userId){

        //添加数据
        Map<String,Object> map = new HashMap();
        map.put("borrowId",borrowId);
        map.put("userId",userId);

        List<BookBorrowHistory> bookBorrowHistories = sqlService.selectMyHistoryByBorrowId(map);

        return bookBorrowHistories;
    }
}
