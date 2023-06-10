package com.LW1_ptlb.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

//生成当前日期，并且格式为 YYYYMMdd
public class DateGenerated {

    public String getNowDate(){

        //获得日期
        Date date = new Date();

        //获得日期格式转换器，格式分别为为 yyyy MM DD
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");

        String nowDate = format.format(date);

        System.out.println(nowDate);

        return nowDate;
    }

}
