package com.LW1_ptlb.service.bookBorrowService;


import com.LW1_ptlb.utils.DateGenerated;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

//跳转到 确认借阅书籍页面 所对应的服务
@Service
public class GoBorrowService {

    //根据获得的 书名，书本编号，生成借阅的具体信息展示给前端看
    public Map<String,Object> goBorrow(String bookName,String bookId){
        Map<String,Object> map = new HashMap();

        //加入 书名，具体书本id
        map.put("bookName",bookName);
        map.put("bookId",bookId);

        //获得当前日期
        map.put("borrowDate",getBorrowDate());
        //获得应该归还的日期（当前日期的7天后）
        map.put("returnDate",getReturnDate());

        System.out.println(map);

        return map;
    }



    //获得当前日期，格式为 YYYY-MM-dd
    private Date getBorrowDate(){
        DateGenerated dateGenerated = new DateGenerated();
        String nowDate = dateGenerated.getNowDate();//获得当前日期，格式为 YYYY-MM-dd
        Date date = Date.valueOf(nowDate);//转换为数据库的日期格式
        return date;
    }

    //获得当前日七天后的日期
    private Date getReturnDate(){

        DateGenerated dateGenerated = new DateGenerated();
        String returnDate = dateGenerated.getReturnDate();//获得当前时间7天后的时间
        Date date = Date.valueOf(returnDate);//转换为数据库的日期格式
        return date;

    }

}
