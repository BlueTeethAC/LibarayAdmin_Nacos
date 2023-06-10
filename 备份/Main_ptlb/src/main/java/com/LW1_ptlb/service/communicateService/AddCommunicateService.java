package com.LW1_ptlb.service.communicateService;

import com.LW1_ptlb.feign.Communicate_ptlb_feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

//新增书籍推荐
@Service
public class AddCommunicateService {

    //获得 Communicate_ptlb_feign 服务
    @Autowired
    Communicate_ptlb_feign communicate_ptlb_feign;

    @ResponseBody
    public Integer addCommunicate(String bookCommunicateName, String bookCommunicateSynopsis,String bookCommunicatePicture,String userName){
        Integer i = communicate_ptlb_feign.addCommunicate(bookCommunicateName, bookCommunicateSynopsis, bookCommunicatePicture, userName);
        return i;
        //0：新增失败   1：新增成功
    }

}
