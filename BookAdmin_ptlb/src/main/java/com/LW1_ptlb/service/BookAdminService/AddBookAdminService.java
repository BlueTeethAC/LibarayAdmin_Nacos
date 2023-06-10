package com.LW1_ptlb.service.BookAdminService;

import com.LW1_ptlb.pojo.BookCount;
import com.LW1_ptlb.service.BookService.AddBookService;
import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

//添加新的书名服务
@Service
public class AddBookAdminService {

    //获得 sql服务
    @Autowired
    SQLService sqlService;

    //获得 添加具体书本服务
    @Autowired
    AddBookService addBookService;

    //添加新的书本
    public Integer addBookName(String bookName,String bookPlace,float bookPrice,Integer maxNum){

        //通过图书名去查询数据库内是否已经有该书名
        String bookName2 = sqlService.selectBookNameByBookName(bookName);


        if (bookName2==null){//查询到的图书名为空时，也就是不重复


            //将 float 转换为两位小数
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            Double price = Double.valueOf(decimalFormat.format(bookPrice));//价格转换为 2 位小数

            //创建集合，将参数添加进去
            Map<String,Object> map = new HashMap();
            map.put("bookName",bookName);//书名
            map.put("bookPlace",bookPlace);//图书存放位置 书柜号+L+行号（例：AL1）
            map.put("bookPrice",price);//书本单价
            map.put("maxNum",maxNum);//书本最大数量

            Integer i=0;



            try{
                i = sqlService.addBookAdmin(map);//返回 0：书名插入失败    返回 1：书名插入成功
            }catch (Exception e){
                System.err.println("书名插入失败！\n"+e);
            }

            if (i==1){//书名插入成功

                BookCount bookCount = sqlService.selectBookAdminByBookName(bookName);//如果上面书名插入成功，则一定可以获得 该书名的 信息
                Integer bookNameId = bookCount.getBookNameId();//获得 书名信息的 id
                String nowBookNameId= String.valueOf(bookNameId);//将 书名信息的 id 转换为 字符串格式

                i=2;//如果书名插入成功，i 就设为 2

                for (int j=1;j<=maxNum;j++){

                    String num= String.valueOf(j);//将 j 转为 字符串格式

                    String bookId=nowBookNameId+"A"+num;//拼接 书本 id

                    try{
                        i = addBookService.addBook(bookNameId, bookId);//调用添加书本服务
                    }catch(Exception e){//如果书名插入失败，就报错，并且停止循环，并且返回 i=2
                        System.err.println("具体书本信息插入失败！\n"+e);

                        //把插入的书名信息删除
                        Integer integer = sqlService.deleteBookAdmin(bookName);

                        i=2;
                        return i;
                    }
                }

                if (maxNum.equals(0)){//如果初始数量本身就为0，那就直接赋值 i=1，不然会返回2
                    i=1;
                }

                return i;//如果全部执行成功就返回 1

            }else {//书名插入失败
                return i;//0：书名插入失败   1：书名和书本都插入成功     2：书名插入成功，但是具体书本插入失败      3：书名重复
            }


        }else {//当输入的书名已经存在于数据库中时

            return 3;//0：书名插入失败   1：书名和书本都插入成功     2：书名插入成功，但是具体书本插入失败      3：书名重复

        }

    }
}
