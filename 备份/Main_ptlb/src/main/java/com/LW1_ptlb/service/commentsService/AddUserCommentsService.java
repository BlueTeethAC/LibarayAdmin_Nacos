package com.LW1_ptlb.service.commentsService;

import com.LW1_ptlb.feign.Communicate_ptlb_feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

//新增用户评论
@Service
public class AddUserCommentsService {

    //获得 Communicate_ptlb_feign 服务
    @Autowired
    Communicate_ptlb_feign communicate_ptlb_feign;

    @ResponseBody
    public Integer addUserComments(String userName, String userComments, Integer bookCommunicateId){
        Integer i = communicate_ptlb_feign.addUserComments(userName, userComments, bookCommunicateId);
        return i;
        //0：新增失败   1：新增成功
    }

}
