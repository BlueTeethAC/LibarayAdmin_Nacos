package com.LW1_ptlb.service.communicateService;

import com.LW1_ptlb.feign.Communicate_ptlb_feign;
import com.LW1_ptlb.pojo.BookCommunicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//按照推荐的书籍名查询固定用户的书籍推荐（用户名固定，书籍名为模糊查询）
@Service
public class GetCommunicateByNameService {

    //获得 Communicate_ptlb_feign 服务
    @Autowired
    Communicate_ptlb_feign communicate_ptlb_feign;

    @ResponseBody
    public List<BookCommunicate> getCommunicateByName(String bookCommunicateName,String userName){
        List<BookCommunicate> communicateByName = communicate_ptlb_feign.getCommunicateByName(bookCommunicateName, userName);
        return communicateByName;
    }

}
