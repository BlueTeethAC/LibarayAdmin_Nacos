package com.LW1_ptlb.service.bookService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//获得所有具体书本的信息
@Service
public class GetAllBookService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    //返回所有具体书本信息
    @ResponseBody
    public List<Book> getAllBook(){
        List<Book> allBookInfo = bookAdmin_pltb_feign.getAllBookInfo();
        return allBookInfo;
    }
}
