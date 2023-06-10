package com.LW1_ptlb.controller.bookAdminController.bookAdminController;

import com.LW1_ptlb.service.bookAdminService.DeleteBookAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//删除图书存量信息控制
@Controller
public class DeleteBookAdminController {

    //获得删除图书存量信息服务
    @Autowired
    DeleteBookAdminService deleteBookAdminService;

    @RequestMapping("/main/deleteBookAdmin/{bookName}")
    public String deleteBookAdmin(@PathVariable("bookName") String bookName){

        System.err.println(bookName);

        Integer i = deleteBookAdminService.deleteBookAdmin(bookName);//删除图书存量信息
        //0：具体书本删除失败     1：具体书本 和 书名信息 都删除成功！    2：具体书本删除成功，但是 书名信息 删除失败！    3：表示没有查询书名
        return "redirect:/main/goBookAdmin";
    }

}
