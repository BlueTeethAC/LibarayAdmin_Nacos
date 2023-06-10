package com.LW1_ptlb.controller.bookAdminController;

import com.LW1_ptlb.service.BookAdminService.AddBookAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//添加书名控制
@RestController
public class AddBookAdminController {

    //获得 addBookNameService
    @Autowired
    AddBookAdminService addBookAdminService;


    @RequestMapping("/addBookAdmin/{bookName}/{bookPlace}/{bookPrice}/{maxNum}")
    public Integer addBookName(@PathVariable("bookName") String bookName,@PathVariable("bookPlace") String bookPlace,@PathVariable("bookPrice") float bookPrice,@PathVariable("maxNum") Integer maxNum){

        System.err.println(bookPrice);

        //执行添加书名方法（内部包含了添加书本）
        Integer i = addBookAdminService.addBookName(bookName, bookPlace, bookPrice, maxNum);//0：书名插入失败   1：书名和书本都插入成功     2：书名插入成功，但是具体书本插入失败

        return i;//0：书名插入失败   1：书名和书本都插入成功     2：书名插入成功，但是具体书本插入失败
    }

}
