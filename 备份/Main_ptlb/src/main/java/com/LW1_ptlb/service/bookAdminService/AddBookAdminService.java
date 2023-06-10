package com.LW1_ptlb.service.bookAdminService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//添加图书存量信息服务
@Service
public class AddBookAdminService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    //添加图书存量信息
    public Integer addBookAdmin(String bookName,String bookPlace1,String bookPlace2,float bookPrice,Integer maxNum){

        //将图书存放位置的 书柜号 和 行 拼成字符串
        String bookPlace=bookPlace1+"L"+bookPlace2;
        System.out.println(bookPlace);

        Integer i = bookAdmin_pltb_feign.addBookAdmin(bookName, bookPlace, bookPrice, maxNum);
        //0：书名插入失败   1：书名和书本都插入成功     2：书名插入成功，但是具体书本插入失败      3：书名重复
        return i;
    }

}
