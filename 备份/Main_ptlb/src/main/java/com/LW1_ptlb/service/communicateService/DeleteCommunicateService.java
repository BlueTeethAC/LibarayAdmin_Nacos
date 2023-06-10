package com.LW1_ptlb.service.communicateService;

import com.LW1_ptlb.feign.Communicate_ptlb_feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

//根据书籍推荐id删除书籍推荐
@Service
public class DeleteCommunicateService {

    //获得 Communicate_ptlb_feign 服务
    @Autowired
    Communicate_ptlb_feign communicate_ptlb_feign;

    @ResponseBody
    public Integer deleteCommunicate(Integer bookCommunicateId){
        Integer i = communicate_ptlb_feign.deleteCommunicate(bookCommunicateId);
        return i;//0：删除失败       1：删除成功      其他的数字：删除异常
    }

}
