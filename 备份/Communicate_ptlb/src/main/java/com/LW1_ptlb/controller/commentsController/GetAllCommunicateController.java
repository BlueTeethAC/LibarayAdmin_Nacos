package com.LW1_ptlb.controller.commentsController;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.pojo.UserComments;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//查询所有的书籍推荐控制
@RestController
public class GetAllCommunicateController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //查询所有的书籍推荐
    @RequestMapping("/getAllCommunicate")
    public List<BookCommunicate> getAllCommunicate(){
        List<BookCommunicate> allBookCommunicate = sqlService.getAllBookCommunicate();
        return allBookCommunicate;
    }

}
