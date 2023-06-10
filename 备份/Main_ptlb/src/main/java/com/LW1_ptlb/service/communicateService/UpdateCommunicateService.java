package com.LW1_ptlb.service.communicateService;

import com.LW1_ptlb.feign.Communicate_ptlb_feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

//根据书籍推荐id修改书籍推荐
@Service
public class UpdateCommunicateService {

    //获得 Communicate_ptlb_feign 服务
    @Autowired
    Communicate_ptlb_feign communicate_ptlb_feign;

    @ResponseBody
    public Integer updateCommunicate( String bookCommunicateName,String bookCommunicateSynopsis,  Integer bookCommunicateId){
        Integer i = communicate_ptlb_feign.updateCommunicate(bookCommunicateName, bookCommunicateSynopsis, bookCommunicateId);
        return i;//0：更新失败       1：更新成功      其他的数字：更新异常
    }

}
