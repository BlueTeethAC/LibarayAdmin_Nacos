package com.LW1_ptlb.controller.communicateController;

import com.LW1_ptlb.pojo.UserComments;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//查询所有用户评论 控制
@RestController
public class GetAllUserCommentsController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //查询所有用户评论
    @RequestMapping("/getAllComments")
    public List<UserComments> getAllComments(){
        List<UserComments> allUserComments = sqlService.getAllUserComments();
        return allUserComments;
    }

}
