package com.LW1_ptlb.controller.bookAdminController;

import com.LW1_ptlb.pojo.BookCount;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照书名查询书名信息控制
@RestController
public class SelectBookAdminByBookNameController {

    //获得 sql服务
    @Autowired
    SQLService sqlService;

    //按照书名查询书名信息
    @RequestMapping("/getBookAdmin/{bookName}")
    public BookCount getBookAdmin(@PathVariable("bookName") String bookName){
        BookCount bookCount = sqlService.selectBookAdminByBookName(bookName);

        System.out.println("==========================");
        System.out.println(bookCount);

        return bookCount;
    }

}
