package com.LW1_ptlb.service.BookAdminService;

import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//修改图书库存信息（书名信息）服务
@Service
public class UpdateBookAdminService {

    //获得 SQL语句 服务
    @Autowired
    SQLService sqlService;

    //接收数据
    public Integer updateBookAdmin(Integer bookNameId,String bookName,String bookPlace,float bookPrice,Integer maxNum){

        Map<String,Object> map = new HashMap();
        map.put("bookNameId",bookNameId);
        map.put("bookName",bookName);
        map.put("bookPlace",bookPlace);
        map.put("bookPrice",bookPrice);
        map.put("maxNum",maxNum);

        //调用更新图书信息服务的方法
        Integer i = sqlService.updateBookAdmin(map);

        if (i.equals(1)){//只更新的一条数据 正常
            return i;
        }else if (i.equals(0)){//没更新到数据 不正常
            return i;
        }else {//更新了多条数据，肯定不正常
            return i;
        }//0：更新失败   1：更新成功  非0和1：更新了多条数据，有问题
    }

}
