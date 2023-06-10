package com.LW1_ptlb.controller.bookAdminController;

import com.LW1_ptlb.pojo.BookCount;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//按照书名查询书名信息控制（模糊查询）
@RestController
public class SelectBookAdminByBookName2Controller {

    //获得 sql服务
    @Autowired
    SQLService sqlService;

    //按照书名查询书名信息（模糊查询）
    @RequestMapping("/getBookAdmin2/{bookName}")
    public List<BookCount> getBookAdmin2(@PathVariable("bookName") String bookName){
        List<BookCount> bookCount = sqlService.selectBookAdminByBookName2(bookName);

        System.out.println("==========================");
        System.out.println(bookCount);

        return bookCount;
    }

}
