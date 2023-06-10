package com.LW1_ptlb.service.bookService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//根据书名查询所有具体书本信息服务
@Service
public class GetBookByNameService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    //根据书名查询所有具体书本信息
    @ResponseBody
    public List<Book> getBookInfoByName(String bookName){
        List<Book> book = bookAdmin_pltb_feign.getBookInfoByBookName(bookName);
        return book;
    }

}
