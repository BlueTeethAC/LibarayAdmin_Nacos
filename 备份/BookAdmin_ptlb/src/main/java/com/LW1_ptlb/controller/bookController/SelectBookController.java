package com.LW1_ptlb.controller.bookController;

import com.LW1_ptlb.pojo.Book;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//查询所有具体书本信息
@RestController
public class SelectBookController {

    //获得数据库语句服务
    @Autowired
    SQLService sqlService;

    //查询所有的具体书本信息
    @RequestMapping("/getAllBookInfo")
    public List<Book> getAllBookInfo(){

        List<Book> books = sqlService.selectAllBook();

        return books;
    }

}
