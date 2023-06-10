package com.LW1_ptlb.service.bookBorrowService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.BookBorrowHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//获得 个人书籍借阅记录
@Service
public class GetMyBorrowHistoryService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    //调用 按照用户名查询个人书籍借阅记录方法
    @ResponseBody
    public List<BookBorrowHistory> getMyBorrowHistory(String userName){
        List<BookBorrowHistory> borrowHistory = bookAdmin_pltb_feign.myBorrowHistory(userName);
        return borrowHistory;
    }
}
