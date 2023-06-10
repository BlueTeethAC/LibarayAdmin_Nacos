package com.LW1_ptlb.controller.communicateController;

import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//删除用户评论 控制
@RestController
public class DeleteUserCommentsController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //删除用户评论
    @RequestMapping("/deleteUserComments/{commentsId}")
    public Integer deleteUserComments(@PathVariable("commentsId") Integer commentsId){

        Integer i = sqlService.deleteUserComments(commentsId);

        return i;//0：删除失败   1：删除成功
    }

}
