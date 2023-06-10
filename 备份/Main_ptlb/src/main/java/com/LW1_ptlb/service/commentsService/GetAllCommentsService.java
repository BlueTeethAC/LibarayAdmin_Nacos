package com.LW1_ptlb.service.commentsService;

import com.LW1_ptlb.feign.Communicate_ptlb_feign;
import com.LW1_ptlb.pojo.UserComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//查询所有用户评论
@Service
public class GetAllCommentsService {

    //获得 Communicate_ptlb_feign 服务
    @Autowired
    Communicate_ptlb_feign communicate_ptlb_feign;

    @ResponseBody
    public List<UserComments> getAllComments(){
        List<UserComments> allComments = communicate_ptlb_feign.getAllComments();
        return allComments;
    }

}
