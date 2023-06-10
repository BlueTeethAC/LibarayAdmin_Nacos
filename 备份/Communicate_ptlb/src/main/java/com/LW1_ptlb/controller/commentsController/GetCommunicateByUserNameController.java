package com.LW1_ptlb.controller.commentsController;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照用户名查询书籍推荐控制
@RestController
public class GetCommunicateByUserNameController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //按照用户名查询书籍推荐
    @RequestMapping("/getCommunicateByUserName/{userName}")
    public List<BookCommunicate> getCommunicateByUserName(@PathVariable("userName") String userName){
        List<BookCommunicate> bookCommunicateByUserName = sqlService.getBookCommunicateByUserName(userName);
        return bookCommunicateByUserName;
    }
}
