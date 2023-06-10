package com.LW1_ptlb.controller.bookController;

import com.LW1_ptlb.service.BookService.AddBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//添加具体单本书籍
@RestController
public class AddBookController {

    //获得 addBookService
    @Autowired
    AddBookService addBookService;

    //添加具体的书本 参数为 书名编号，书本编号（就是该书名的第几本书）
    @RequestMapping("/addBook/{bookNameId}/{bookId}")
    public Integer addBook(@PathVariable("bookNameId") Integer bookNameId,@PathVariable("bookId") String bookId){

        System.out.println(bookNameId);
        System.out.println(bookId);

        Integer i = addBookService.addBook(bookNameId, bookId);//返回 1：插入成功  0：插入失败  3：已有该书本信息(bookId 重复)

        return i;//返回 1：插入成功  0：插入失败  3：已有该书本信息(bookId 重复)
    }

}
