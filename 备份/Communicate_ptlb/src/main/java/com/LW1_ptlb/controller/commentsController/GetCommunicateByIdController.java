package com.LW1_ptlb.controller.commentsController;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//按照书籍推荐id查询书记推荐信息
@RestController
public class GetCommunicateByIdController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    @RequestMapping("/getCommunicateById/{bookCommunicateId}")
    public BookCommunicate getCommunicateById(@PathVariable("bookCommunicateId") Integer bookCommunicateId){
        BookCommunicate bookCommunicateById = sqlService.getBookCommunicateById(bookCommunicateId);
        return bookCommunicateById;
    }

}
