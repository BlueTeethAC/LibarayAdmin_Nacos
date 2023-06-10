package com.LW1_ptlb.service.commentsService;

import com.LW1_ptlb.service.SQLService.SQLService;
import com.LW1_ptlb.utils.DateGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

//新增用户评论
@Service
public class AddUserCommentsService {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    @RequestMapping("/addUserComments")
    public Integer addUserComments(String userName, String userComments, Integer bookCommunicateId){

        Map<String,Object> map=new HashMap();

        map.put("userName",userName);
        map.put("userComments",userComments);
        map.put("bookCommunicateId",bookCommunicateId);

        Date date = getDateNum();//获得当前日期
        System.err.println(date);

        map.put("commentsDate",date);

        Integer i = sqlService.addUserComments(map);

        return i;//0：新增失败   1：新增成功
    }

    //获得当前日期，格式为 YYYY-MM-dd
    private Date getDateNum(){
        DateGenerated dateGenerated = new DateGenerated();
        String nowDate = dateGenerated.getNowDate();//获得当前日期，格式为 YYYY-MM-dd
        Date date = Date.valueOf(nowDate);//转换为数据库的日期格式
        return date;
    }

}
