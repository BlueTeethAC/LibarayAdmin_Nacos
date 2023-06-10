package com.LW1_ptlb.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//生成当前日期，并且格式为 YYYY-MM-dd
public class DateGenerated {

    public String getNowDate(){

        //获得日期
        Date date = new Date();

        //获得日期格式转换器，格式分别为为 yyyy MM DD
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");

        String nowDate = format.format(date);

        System.out.println(nowDate);

        return nowDate;
    }


    //获得当前日期七天后的日期
    public String getReturnDate(){

        //获得日期
        Date date = new Date();

        //获得日期格式转换器，格式分别为为 yyyy MM DD
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,7);//设置添加七天时间
        date=calendar.getTime();//给当前日期添加七天时间

        String returnDate = format.format(date);

        return returnDate;
    }

}
