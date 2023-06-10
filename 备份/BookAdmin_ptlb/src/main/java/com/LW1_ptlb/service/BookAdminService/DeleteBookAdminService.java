package com.LW1_ptlb.service.BookAdminService;

import com.LW1_ptlb.pojo.BookCount;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//按照书名 删除书名信息（并且会一同删除对应所有的具体书本）
@Service
public class DeleteBookAdminService {

    //获得 SQL语句 服务
    @Autowired
    SQLService sqlService;

    //按照书名删除书名信息
    public Integer deleteBookAdmin(String bookName){//返回 0：具体书本删除失败     1：具体书本 和 书名信息 都删除成功！    2：具体书本删除成功，但是 书名信息 删除失败！    3：表示没有查询书名

        String s = sqlService.selectBookNameByBookName(bookName);//查询书名，查看是否有该书本
        System.err.println(s);

        if (bookName.equals(s)){//如果有查询到书名

            //查询获得 bookCount
            BookCount bookCount = sqlService.selectBookAdminByBookName(s);
            //获得对应的 bookNameId
            Integer bookNameId = bookCount.getBookNameId();

            System.err.println("==============================");
            System.err.println(bookNameId);
            System.err.println("==============================");

            Integer i = sqlService.deleteBookByBookNameId(bookNameId);//按照书名id 删除所有对应的书本
            System.out.println("删除了 "+i+" 条 书本具体信息！");

            //如果该书本的初始数量就为0，那就不需要删除具体书本了
            if (bookCount.getMaxNum().equals(0)){
                i=1;
            }


            if (i==0){//如果具体书本都删除失败！

                return i;//返回 0：具体书本删除失败

            }else {//如果具体书本都删除成功！

                Integer j = sqlService.deleteBookAdmin(bookName);//删除书名信息

                if (j==1){//当书名也删除成功！
                    return j;//1：具体书本 和 书名信息 都删除成功！
                }else {
                    return 2;//2：具体书本删除成功，但是 书名信息 删除失败！
                }

            }

        }else {//如果没查询到
            return 3;//返回 3，3表示没有查询书名
        }


    }

}
