package com.LW1_ptlb.service.commentsService;

import com.LW1_ptlb.feign.Communicate_ptlb_feign;
import com.LW1_ptlb.pojo.UserComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//按照用户名和日期查询评论记录（日期为模糊查询）
@Service
public class GetUserCommentsByUserDateService {

    //获得 Communicate_ptlb_feign 服务
    @Autowired
    Communicate_ptlb_feign communicate_ptlb_feign;

    @ResponseBody
    public List<UserComments> getUserCommentsByUserDate(String userName,String date){
        List<UserComments> userCommentsByUserDate = communicate_ptlb_feign.getUserCommentsByUserDate(userName, date);
        return userCommentsByUserDate;
    }

}
