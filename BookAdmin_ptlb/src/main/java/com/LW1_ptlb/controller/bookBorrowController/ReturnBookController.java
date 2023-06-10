package com.LW1_ptlb.controller.bookBorrowController;

import com.LW1_ptlb.service.BookBorrowService.ReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//还书（需要修改借阅记录状态，修改具体书本状态）控制
@RestController
public class ReturnBookController {

    //调用还书服务
    @Autowired
    ReturnBookService returnBookService;

    @RequestMapping("/returnBook/{returnStatus}/{borrowId}/{bookId}")
    public Integer returnBook(@PathVariable("returnStatus") Integer returnStatus,@PathVariable("borrowId") Integer borrowId,@PathVariable("bookId") String bookId){
        Integer i = returnBookService.returnBook(returnStatus, borrowId, bookId);
        return i;
        //0：修改借阅记录状态失败     1：借阅记录状态 和 具体书本状态都修改成功      2：借阅记录状态修改异常    3：借阅记录状态修改成功，具体书本借阅状态修改失败      4：借阅记录状态修改成功，具体书本借阅状态修改异常
    }

}
