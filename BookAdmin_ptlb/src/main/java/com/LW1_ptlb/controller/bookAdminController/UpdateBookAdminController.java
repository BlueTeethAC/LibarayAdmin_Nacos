package com.LW1_ptlb.controller.bookAdminController;

import com.LW1_ptlb.service.BookAdminService.UpdateBookAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//修改图书库存信息（书名信息）控制
@RestController
public class UpdateBookAdminController {

    //获得 修改图书库存信息（书名信息）服务
    @Autowired
    UpdateBookAdminService updateBookAdminService;

    //修改 图书库存信息（书名信息）
    @RequestMapping("/updateBookAdmin/{bookNameId}/{bookName}/{bookPlace}/{bookPrice}/{maxNum}")
    public Integer updateBookAdmin(@PathVariable("bookNameId") Integer bookNameId,@PathVariable("bookName") String bookName,@PathVariable("bookPlace") String bookPlace,@PathVariable("bookPrice") float bookPrice,@PathVariable("maxNum") Integer maxNum){

        //调用  修改图书库存信息服务 的 方法
        Integer i = updateBookAdminService.updateBookAdmin(bookNameId, bookName, bookPlace, bookPrice, maxNum);


        return i;//0：更新失败   1：更新成功  非0和1：更新了多条数据，有问题
    }

}
