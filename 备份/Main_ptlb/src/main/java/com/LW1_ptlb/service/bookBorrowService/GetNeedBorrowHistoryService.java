package com.LW1_ptlb.service.bookBorrowService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.BookBorrowHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//按照用户名获得需要归还的书籍借阅记录
@Service
public class GetNeedBorrowHistoryService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    @ResponseBody
    public List<BookBorrowHistory> getNeedBorrowHistory(String userName){
        //获得需要规范的书籍借阅记录
        List<BookBorrowHistory> needReturnBook = bookAdmin_pltb_feign.getNeedReturnBook(userName);
        return needReturnBook;
    }
}
