package com.LW1_ptlb.service.bookBorrowService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

//归还书籍服务
@Service
public class ReturnBookService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    //归还书籍方法
    @ResponseBody
    public Integer returnBook(Integer returnStatus,Integer borrowId,String bookId){

        Integer i = bookAdmin_pltb_feign.returnBook(returnStatus, borrowId, bookId);
        //0：修改借阅记录状态失败     1：借阅记录状态 和 具体书本状态都修改成功      2：借阅记录状态修改异常    3：借阅记录状态修改成功，具体书本借阅状态修改失败      4：借阅记录状态修改成功，具体书本借阅状态修改异常

        return i;
    }
}
