package com.LW1_ptlb.controller.bookAdminController;

import com.LW1_ptlb.pojo.BookCount;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//查询所有 图书库存信息（书名信息）
@RestController
public class SelectBookAdminController {

    //获得 sqlService 数据库语句服务
    @Autowired
    SQLService sqlService;

    //直接查询所有书名信息
    @RequestMapping("/getAllBookAdmin")
    public List<BookCount> selectBookAdmin(){
        List<BookCount> bookCounts = sqlService.selectBookAdmin();
        return bookCounts;
    }

}
