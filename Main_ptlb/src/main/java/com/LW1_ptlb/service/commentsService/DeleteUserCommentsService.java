package com.LW1_ptlb.service.commentsService;

import com.LW1_ptlb.feign.Communicate_ptlb_feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

//删除用户评论
@Service
public class DeleteUserCommentsService {

    //获得 Communicate_ptlb_feign 服务
    @Autowired
    Communicate_ptlb_feign communicate_ptlb_feign;

    @ResponseBody
    public Integer deleteUserComments(Integer commentsId){
        Integer i = communicate_ptlb_feign.deleteUserComments(commentsId);
        return i;//0：删除失败       1：删除成功      其他的数字：删除异常
    }

}
