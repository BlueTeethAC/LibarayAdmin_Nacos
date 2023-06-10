package com.LW1_ptlb.service.bookAdminService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.BookCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//获得所有图书存量信息服务
@Service
public class GetAllBookAdminService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    public List<BookCount> getAllBookAdmin(){

        //获得 所有 图书存量信息
        List<BookCount> bookAdmin = bookAdmin_pltb_feign.getAllBookAdmin();

        System.out.println(bookAdmin);

        return bookAdmin;
    }

}
