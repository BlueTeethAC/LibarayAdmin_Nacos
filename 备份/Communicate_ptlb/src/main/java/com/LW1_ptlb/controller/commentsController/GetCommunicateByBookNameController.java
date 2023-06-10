package com.LW1_ptlb.controller.commentsController;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照推荐的书籍名查询书籍推荐（模糊查询）控制
@RestController
public class GetCommunicateByBookNameController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //按照推荐的书籍名查询书籍推荐（模糊查询）
    @RequestMapping("/getCommunicateByBookName/{bookName}")
    public List<BookCommunicate> getCommunicateByBookName(@PathVariable("bookName") String bookName){
        List<BookCommunicate> bookCommunicateByBookName = sqlService.getBookCommunicateByBookName(bookName);
        return bookCommunicateByBookName;
    }

}
