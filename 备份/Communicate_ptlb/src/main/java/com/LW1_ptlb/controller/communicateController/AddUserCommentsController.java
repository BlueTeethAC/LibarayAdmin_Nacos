package com.LW1_ptlb.controller.communicateController;

import com.LW1_ptlb.service.SQLService.SQLService;
import com.LW1_ptlb.service.commentsService.AddUserCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//新增用户评论 控制
@RestController
public class AddUserCommentsController {

    //获得 新增用户评论服务
    @Autowired
    AddUserCommentsService addUserCommentsService;

    //新增用户评论
    @RequestMapping("/addUserComments/{userName}/{userComments}/{bookCommunicateId}")
    public Integer addUserComments(@PathVariable("userName") String userName,@PathVariable("userComments") String userComments,@PathVariable("bookCommunicateId") Integer bookCommunicateId){

        //新增用户评论
        Integer i = addUserCommentsService.addUserComments(userName, userComments, bookCommunicateId);
        return i;//0：新增失败   1：新增成功

    }

}
