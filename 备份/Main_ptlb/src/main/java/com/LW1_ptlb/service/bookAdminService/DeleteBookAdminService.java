package com.LW1_ptlb.service.bookAdminService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

//删除图书存量信息服务
@Service
public class DeleteBookAdminService {

    //获得 BookAdmin_pltb_feign
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    @ResponseBody
    public Integer deleteBookAdmin(String bookName){
        Integer i = bookAdmin_pltb_feign.deleteBookAdmin(bookName);//调用删除图书存量信息方法
        //0：具体书本删除失败     1：具体书本 和 书名信息 都删除成功！    2：具体书本删除成功，但是 书名信息 删除失败！    3：表示没有查询书名
        return i;
    }

}
