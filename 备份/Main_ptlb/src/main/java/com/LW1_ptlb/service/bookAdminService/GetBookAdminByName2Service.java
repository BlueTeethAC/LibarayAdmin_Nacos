package com.LW1_ptlb.service.bookAdminService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.BookCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//根据书名来模糊查询 书籍存量信息
@Service
public class GetBookAdminByName2Service {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    //模糊查询 书籍存量信息
    @ResponseBody
    public List<BookCount> getBookAdminByName(String bookName){
        List<BookCount> bookAdmin = bookAdmin_pltb_feign.getBookAdmin2(bookName);
        return bookAdmin;
    }

}
