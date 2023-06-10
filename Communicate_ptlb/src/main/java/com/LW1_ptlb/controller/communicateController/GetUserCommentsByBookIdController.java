package com.LW1_ptlb.controller.communicateController;

import com.LW1_ptlb.pojo.UserComments;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照书籍推荐编号查询对应书籍的所有评论 控制
@RestController
public class GetUserCommentsByBookIdController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //按照书籍推荐编号查询对应书籍的所有评论
    @RequestMapping("/getUserCommentsByBookId/{bookCommunicateId}")
    public List<UserComments> getUserCommentsByBookId(@PathVariable("bookCommunicateId") Integer bookCommunicateId){
        List<UserComments> userCommentsByBookId = sqlService.getUserCommentsByBookId(bookCommunicateId);
        return userCommentsByBookId;
    }

}
