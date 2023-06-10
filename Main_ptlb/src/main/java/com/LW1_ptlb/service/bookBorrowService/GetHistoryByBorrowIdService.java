package com.LW1_ptlb.service.bookBorrowService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.BookBorrowHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//按照记录编号查询书籍借阅记录
@Service
public class GetHistoryByBorrowIdService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    @ResponseBody
    List<BookBorrowHistory> getHistoryByBorrowId(Integer borrowId){
        List<BookBorrowHistory> historyByBorrowId = bookAdmin_pltb_feign.getHistoryByBorrowId(borrowId);
        return historyByBorrowId;
    }
}
