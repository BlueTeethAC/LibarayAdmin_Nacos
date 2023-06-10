package com.LW1_ptlb.controller.bookAdminController;

import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//按照书名去查询书名id（辅助）
@RestController
public class SelectBookAdminIdByNameController {

    //获得 sqlService 数据库语句服务
    @Autowired
    SQLService sqlService;

    //按照书名去查询书名id（辅助）
    @RequestMapping("/getBookAdminIdByName/{bookName}")
    public Integer getBookAdminIdByName(@PathVariable("bookName") String bookName){
        Integer bookNameId = sqlService.selectBookNameIdByBookName(bookName);
        return bookNameId;
    }
}
