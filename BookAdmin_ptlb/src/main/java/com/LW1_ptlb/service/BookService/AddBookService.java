package com.LW1_ptlb.service.BookService;

import com.LW1_ptlb.pojo.Book;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//添加新的具体书本的服务
@Service
public class AddBookService {

    //获得 sqlService
    @Autowired
    SQLService sqlService;

    //添加具体的书本 参数为 书名编号，书本编号（就是该书名的第几本书）
    public Integer addBook(Integer bookNameId,String bookId){

        //按照输入的 bookid 去查询是否已经存在
        String id = sqlService.selectBookIdByBookId(bookId);

        if (id==null){//当 bookId 没有重复

            //将数据传入集合
            Map map=new HashMap<String,Object>();
            map.put("bookNameId",bookNameId);//书名编号
            map.put("bookId",bookId);//书本编号

            Integer i=0;

            try{

                i = sqlService.addBookInfo(map);//调用 addBookInfo 方法，返回 1：插入成功  0：插入失败

            }catch(Exception e){

                System.err.println("SQL具体书本插入失败\n"+e);

            }

            return i;//返回 1：插入成功  0：插入失败  3：已有该书本信息(bookId 重复)

        }else {//当输入的 bookId 已经存在于数据库中时

            System.err.println("数据库内已有该本书的信息！");

            return 3;//返回 1：插入成功  0：插入失败  3：已有该书本信息(bookId 重复)

        }

    }
}
