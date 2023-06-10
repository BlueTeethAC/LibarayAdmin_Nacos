package com.LW1_ptlb.service.bookBorrowService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//根据书名查询所有当前可以借阅的书籍
@Service
public class GetCanBorrowBookByNameService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    public List<Book> getCanBorrowBook(String bookName){

        System.out.println("======================");
        System.out.println(bookName);
        System.out.println("======================");

        List<Book> book = bookAdmin_pltb_feign.getCanBorrowBookByName(bookName);

        System.out.println(book);

        return book;
        //按照书名查询所有当前可以借阅的书籍
    }


}
