package com.LW1_ptlb.controller.commentsController;

import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//根据书籍推荐id删除书籍推荐控制
@RestController
public class DeleteCommunicateController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //根据书籍推荐id删除书籍推荐
    @RequestMapping("/deleteCommunicate/{bookCommunicateId}")
    public Integer deleteBookCommunicate(@PathVariable("bookCommunicateId") Integer bookCommunicateId){
        Integer i = sqlService.deleteBookCommunicate(bookCommunicateId);
        return i;//0：删除失败       1：删除成功      其他的数字：删除异常
    }

}
