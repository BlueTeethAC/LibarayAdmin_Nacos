package com.LW1_ptlb.service.bookAdminService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

//修改图书存量信息服务
@Service
public class UpdateBookAdminService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    //修改图书存量信息
    @ResponseBody
    public Integer updateBookAdmin(Integer bookNameId,String bookName,String bookPlace1,String bookPlace2,float bookPrice,Integer maxNum){

        //将图书存放位置的 书柜号 和 行 拼成字符串
        String bookPlace=bookPlace1+"L"+bookPlace2;
        System.out.println(bookPlace);

        Integer i = bookAdmin_pltb_feign.updateBookAdmin(bookNameId, bookName, bookPlace, bookPrice, maxNum);
        //0：更新失败   1：更新成功  非0和1：更新了多条数据，有问题

        return i;
    }


}
