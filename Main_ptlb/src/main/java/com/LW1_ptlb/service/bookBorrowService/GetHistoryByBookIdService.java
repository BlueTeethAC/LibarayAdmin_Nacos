package com.LW1_ptlb.service.bookBorrowService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.BookBorrowHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//按照书本编号查询查询书籍借阅记录（模糊查询）
@Service
public class GetHistoryByBookIdService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    @ResponseBody
    public List<BookBorrowHistory> getHistoryByBookId(String bookId){
        List<BookBorrowHistory> historyByBookId = bookAdmin_pltb_feign.getHistoryByBookId(bookId);
        return historyByBookId;
    }
}
