package com.LW1_ptlb.service.BookBorrowService;

import com.LW1_ptlb.service.SQLService.SQLService;
import com.LW1_ptlb.utils.DateGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

//用户借阅书籍（生成一条借阅记录） 服务，如果借阅成功，那还需要把 具体书本书本状态 改为 1
@Service
public class AddBorrowHistoryService {

    //获得 数据库语句服务
    @Autowired
    SQLService sqlService;

    public Integer addBorrowHistory( Integer userId, String bookId){

        //获得当前日期，也就是借书日期
        Date borrowDate = getDateNum();

        //获得七天后的日期
        Date returnDate = getReturnDate();

        Map<String,Object> map=new HashMap();
        map.put("userId",userId);
        map.put("bookId",bookId);
        map.put("borrowDate",borrowDate);
        map.put("returnDate",returnDate);

        Integer i=0;

        try {
            i = sqlService.addBorrowHistory(map);
        }catch (Exception e){
            System.err.println("生成借阅信息异常\n"+e);
            return 4;
        }

        if (i.equals(1)){//i=1就是插入成功

            Map<String,Object> map2=new HashMap();

            map2.put("bookId",bookId);
            map2.put("borrowStatus",1);

            Integer j = sqlService.updateBookStatus(map2);//更新具体书本状态

            if (j.equals(1)){//j=1：具体书本状态更新成功！
                return j;
            }else if (j.equals(0)){//j=0，没更新到数据，有问题
                return 2;
            }else {
                return 3;//j不为 0 也不为 1，更新多条数据，有问题
            }

        }else {
            return i;//0:借阅失败   1：借阅成功      2：借阅成功，但是更新具体书本状态失败     3：借阅成功，但是具体书本状态更新了多条数据，有问题      4：借阅异常
        }

    }



    //获得当前日期，格式为 YYYY-MM-dd
    private Date getDateNum(){
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
