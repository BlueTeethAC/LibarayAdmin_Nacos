package com.LW1_ptlb.controller.bookAdminController;

import com.LW1_ptlb.service.BookAdminService.DeleteBookAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//按照 书本名 删除 书名信息 和 所有对应的具体书本信息
@RestController
public class DeleteBookAdminByBookNameController {

    //获得 SQL语句 服务
    @Autowired
    DeleteBookAdminService deleteBookAdmin;

    //通过 书名 删除 书名信息 和 所有对应的具体书本信息
    @RequestMapping("/deleteBookAdmin/{bookName}")
    public Integer deleteBookAdmin(@PathVariable("bookName") String bookName){

        //调用 删除书名方法
        Integer i = deleteBookAdmin.deleteBookAdmin(bookName);

        return i;//返回 0：具体书本删除失败     1：具体书本 和 书名信息 都删除成功！    2：具体书本删除成功，但是 书名信息 删除失败！    3：表示没有查询书名
    }

}
