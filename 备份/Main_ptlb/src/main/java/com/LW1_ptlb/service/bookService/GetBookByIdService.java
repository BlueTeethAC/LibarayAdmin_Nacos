package com.LW1_ptlb.service.bookService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//根据 具体书本id 查询到 具体书本信息
@Service
public class GetBookByIdService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    @ResponseBody
    public List<Book> getBookById(String bookId){

        List<Book> book = bookAdmin_pltb_feign.getBookInfoById(bookId);

        return book;//返回根据 书本id 查询到的具体书本信息
    }
}
