package com.LW1_ptlb.service.communicateService;

import com.LW1_ptlb.feign.Communicate_ptlb_feign;
import com.LW1_ptlb.pojo.BookCommunicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//按照推荐的书籍名查询书籍推荐（模糊查询）
@Service
public class GetCommunicateByBookNameService {

    //获得 Communicate_ptlb_feign 服务
    @Autowired
    Communicate_ptlb_feign communicate_ptlb_feign;

    @ResponseBody
    public List<BookCommunicate> getCommunicateByBookName(String bookName){
        List<BookCommunicate> communicateByBookName = communicate_ptlb_feign.getCommunicateByBookName(bookName);
        return communicateByBookName;
    }

}
