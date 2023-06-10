package com.LW1_ptlb.service.communicateService;

import com.LW1_ptlb.feign.Communicate_ptlb_feign;
import com.LW1_ptlb.pojo.BookCommunicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//按照用户名查询书籍推荐
@Service
public class GetCommunicateByUserNameService {

    //获得 Communicate_ptlb_feign 服务
    @Autowired
    Communicate_ptlb_feign communicate_ptlb_feign;

    @ResponseBody
    public List<BookCommunicate> getCommunicateByUserName(String userName){
        List<BookCommunicate> communicateByUserName = communicate_ptlb_feign.getCommunicateByUserName(userName);
        return communicateByUserName;
    }

}
