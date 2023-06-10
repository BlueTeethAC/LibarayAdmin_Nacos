package com.LW1_ptlb.service.bookBorrowService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.BookBorrowHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//获得 所有书籍借阅记录 服务
@Service
public class GetAllBorrowService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    @ResponseBody
    public List<BookBorrowHistory> getAllBorrow(){
        //获得所有借阅记录
        List<BookBorrowHistory> allBorrow = bookAdmin_pltb_feign.getAllBorrow();
        return allBorrow;
    }
}
