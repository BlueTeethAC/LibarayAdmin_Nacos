package com.LW1_ptlb.service.bookService;

import com.LW1_ptlb.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

//查询具体书本 通过查询 书名 和 书本id（两种结合一起了）
@Service
public class GetBookBySelectService {

    //获得 根据id查询具体书本服务
    @Autowired
    GetBookByIdService getBookByIdService;

    //获得 根据id查询具体书本服务
    @Autowired
    GetBookByNameService getBookByNameService;

    public List<Book> getBookBySelect(String selectBook){
        System.out.println(selectBook);

        //创建总结果集
        List<Book> book = new LinkedList();

        //将输入的字符串作为书名查询的结果
        List<Book> book1 = getBookByNameService.getBookInfoByName(selectBook);
        //将输入的字符串作为id查询的结果
        List<Book> book2 = getBookByIdService.getBookById(selectBook);

        //合并结果集
        book.addAll(book1);
        book.addAll(book2);

        System.err.println("========"+book+"=======");

        return book;
    }

}
