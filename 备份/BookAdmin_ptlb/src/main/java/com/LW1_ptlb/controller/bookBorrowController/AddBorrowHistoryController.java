package com.LW1_ptlb.controller.bookBorrowController;

import com.LW1_ptlb.service.BookBorrowService.AddBorrowHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//用户借阅书籍（生成一条借阅记录） 控制
@RestController
public class AddBorrowHistoryController {

    //获得借阅具体书本服务
    @Autowired
    AddBorrowHistoryService addBorrowHistoryService;

    @RequestMapping("/addBorrow/{userId}/{bookId}")
    public Integer addBorrowHistory(@PathVariable("userId") Integer userId,@PathVariable("bookId") String bookId){

        System.out.println(userId);
        System.out.println(bookId);

        Integer i = addBorrowHistoryService.addBorrowHistory(userId, bookId);

        return i;//0:借阅失败   1：借阅成功      2：借阅成功，但是更新具体书本状态失败     3：借阅成功，但是具体书本状态更新了多条数据，有问题      4：借阅异常
    }

}
