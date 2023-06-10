package com.LW1_ptlb.controller.commentsController;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//按照推荐的书籍名查询固定用户的书籍推荐（用户名固定，书籍名为模糊查询）控制
@RestController
public class GetCommunicateByNameController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //按照推荐的书籍名查询固定用户的书籍推荐（用户名固定，书籍名为模糊查询）
    @RequestMapping("/getCommunicateByName/{bookCommunicateName}/{userName}")
    public List<BookCommunicate> getCommunicateByName(@PathVariable("bookCommunicateName") String bookCommunicateName,@PathVariable("userName") String userName){
        Map<String,String> map=new HashMap();
        map.put("bookCommunicateName",bookCommunicateName);
        map.put("userName",userName);

        List<BookCommunicate> bookCommunicateByName = sqlService.getBookCommunicateByName(map);
        return bookCommunicateByName;
    }

}
