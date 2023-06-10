package com.LW1_ptlb.service.bookService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//新增具体书本信息服务
@Service
public class AddBookService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    @ResponseBody
    public Integer addBook(String bookName,String bookId){

        //判断 bookId 是否在正确范围
        int num= Integer.parseInt(bookId);
        System.out.println(num);
        if (num<0||num>20){
            return 5;//输入的图书编号不在正确范围
        }

        Integer bookNameId = bookAdmin_pltb_feign.getBookNameIdByBookName(bookName);
        System.out.println("bookNameId:"+bookNameId);

        if (bookNameId==null){//没有查询到对应的书名id
            return 4;//4；没有查询到该书名
        }else{//查询到书名了

            //拼接 bookId
            bookId=bookNameId+"A"+bookId;

            Integer i = bookAdmin_pltb_feign.addBook(bookNameId, bookId);
            //返回 1：插入成功  0：插入失败  3：已有该书本信息(bookId 重复)

            return i;//返回 1：插入成功  0：插入失败  3：已有该书本信息(bookId 重复)   4；没有查询到该书名     5：输入的图书编号不在正确范围
        }
    }
}
