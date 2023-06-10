package com.LW1_ptlb.controller.communicateController;

import com.LW1_ptlb.pojo.UserComments;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照用户名查询评论记录 控制
@RestController
public class GetUserCommentsByUserNameController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //按照用户名查询评论记录
    @RequestMapping("/getUserCommentsByUserName/{userName}")
    public List<UserComments> getUserCommentsByUserName(@PathVariable("userName") String userName){
        List<UserComments> userCommentsByUserName = sqlService.getUserCommentsByUserName(userName);
        return userCommentsByUserName;
    }

}
