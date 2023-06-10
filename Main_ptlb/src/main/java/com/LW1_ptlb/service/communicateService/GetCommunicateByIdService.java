package com.LW1_ptlb.service.communicateService;

import com.LW1_ptlb.feign.Communicate_ptlb_feign;
import com.LW1_ptlb.pojo.BookCommunicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//按照书籍推荐id查询书记推荐信息
@Service
public class GetCommunicateByIdService {

    //获得 Communicate_ptlb_feign 服务
    @Autowired
    Communicate_ptlb_feign communicate_ptlb_feign;

    @ResponseBody
    public BookCommunicate getCommunicateById(Integer bookCommunicateId){
        BookCommunicate communicateById = communicate_ptlb_feign.getCommunicateById(bookCommunicateId);
        return communicateById;
    }

}
