package com.LW1_ptlb.controller.bookController;

import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//按照书本id删除具体某一本书
@RestController
public class DeleteBookByBookIdController {

    //获得 sql语句 服务
    @Autowired
    SQLService sqlService;

    @RequestMapping("/deleteBookById/{bookId}")
    public Integer deleteBook(@PathVariable("bookId") String bookId){

        Integer i = sqlService.deleteBookByBookId(bookId);//调用 按照具体书本id 删除书本（实际上是把 status 改为 0）

        return i;//1：删除成功   0：删除失败
    }

}
