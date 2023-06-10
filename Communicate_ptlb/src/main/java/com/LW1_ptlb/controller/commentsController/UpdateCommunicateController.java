package com.LW1_ptlb.controller.commentsController;

import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//根据书籍推荐id修改书籍推荐控制
@RestController
public class UpdateCommunicateController {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    //根据书籍推荐id修改书籍推荐
    @RequestMapping("/updateCommunicate/{bookCommunicateName}/{bookCommunicateSynopsis}/{bookCommunicateId}")
    public Integer updateCommunicate(@PathVariable("bookCommunicateName") String bookCommunicateName,@PathVariable("bookCommunicateSynopsis") String bookCommunicateSynopsis,@PathVariable("bookCommunicateId") String bookCommunicateId){
        Map<String,Object> map=new HashMap();
        map.put("bookCommunicateName",bookCommunicateName);
        map.put("bookCommunicateSynopsis",bookCommunicateSynopsis);
        map.put("bookCommunicateId",bookCommunicateId);

        Integer i = sqlService.updateBookCommunicate(map);
        return i;//0：更新失败       1：更新成功      其他的数字：更新异常
    }

}
