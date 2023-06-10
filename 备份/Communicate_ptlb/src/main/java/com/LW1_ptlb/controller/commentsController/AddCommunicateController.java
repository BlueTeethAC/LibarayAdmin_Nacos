package com.LW1_ptlb.controller.commentsController;

import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//新增书籍推荐控制
@RestController
public class AddCommunicateController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //新增书籍推荐
    @RequestMapping("/addCommunicate/{bookCommunicateName}/{bookCommunicateSynopsis}/{bookCommunicatePicture}/{userName}")
    public Integer addBookCommunicate(@PathVariable("bookCommunicateName") String bookCommunicateName,@PathVariable("bookCommunicateSynopsis") String bookCommunicateSynopsis,@PathVariable("bookCommunicatePicture") String bookCommunicatePicture,@PathVariable("userName") String userName){
        Map<String,String> map=new HashMap();
        map.put("bookCommunicateName",bookCommunicateName);
        map.put("bookCommunicateSynopsis",bookCommunicateSynopsis);
        map.put("bookCommunicatePicture",bookCommunicatePicture);
        map.put("userName",userName);

        Integer i = sqlService.addBookCommunicate(map);
        return i;//0：新增失败   1：新增成功
    }

}
