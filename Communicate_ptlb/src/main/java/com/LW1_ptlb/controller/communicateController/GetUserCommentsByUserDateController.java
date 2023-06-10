package com.LW1_ptlb.controller.communicateController;

import com.LW1_ptlb.pojo.UserComments;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//按照用户名和日期查询评论记录（日期为模糊查询） 控制
@RestController
public class GetUserCommentsByUserDateController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //按照用户名和日期查询评论记录（日期为模糊查询）
    @RequestMapping("/getUserCommentsByUserDate/{userName}/{date}")
    public List<UserComments> getUserCommentsByUserDate(@PathVariable("userName") String userName,@PathVariable("date") String date){

        Map<String,Object> map = new HashMap();

        map.put("userName",userName);
        map.put("commentsDate",date);

        List<UserComments> userCommentsByUserDate = sqlService.getUserCommentsByUserDate(map);

        return userCommentsByUserDate;
    }

}
