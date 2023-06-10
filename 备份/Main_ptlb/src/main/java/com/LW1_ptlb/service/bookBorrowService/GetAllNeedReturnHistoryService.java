package com.LW1_ptlb.service.bookBorrowService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.BookBorrowHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//查询所有未归还的 借阅记录 服务
@Service
public class GetAllNeedReturnHistoryService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    @ResponseBody
    public List<BookBorrowHistory> getAllNeedReturnHistory(){
        //查询所有未归还的 借阅记录
        List<BookBorrowHistory> allNeedReturnHistory = bookAdmin_pltb_feign.getAllNeedReturnHistory();
        return allNeedReturnHistory;
    }
}
