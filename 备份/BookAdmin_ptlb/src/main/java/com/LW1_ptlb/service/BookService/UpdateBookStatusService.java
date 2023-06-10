package com.LW1_ptlb.service.BookService;

import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//根据具体书本id 修改具体书本出借状态
@Service
public class UpdateBookStatusService {

    //获得 SQL语句 服务
    @Autowired
    SQLService sqlService;

    //输入的参数：0：未出借 1：出借 2：逾期未还 3：损坏/遗失
    public Integer updateBook(String bookId,Integer borrowStatus){

        if (borrowStatus>=0&&borrowStatus<=3){//当 输入的 状态代码 在证却范围内时
            System.out.println(bookId);
            System.out.println(borrowStatus);

            //创建 map集合，用于存放数据
            Map<String,Object> map = new HashMap();

            map.put("bookId",bookId);
            map.put("borrowStatus",borrowStatus);

            Integer i = sqlService.updateBookStatus(map);

            return i;//返回 0：修改失败    1：修改成功   2：输入的状态代码 borrowStatus 不正确
        }else {
            return 2;//返回 0：修改失败    1：修改成功   2：输入的状态代码 borrowStatus 不正确
        }


    }
}
