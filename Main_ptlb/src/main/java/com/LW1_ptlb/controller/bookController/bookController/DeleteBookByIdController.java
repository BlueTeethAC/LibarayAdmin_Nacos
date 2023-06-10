package com.LW1_ptlb.controller.bookController.bookController;

import com.LW1_ptlb.service.bookService.DeleteBookByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//根据 书本id 删除具体书本信息
@Controller
public class DeleteBookByIdController {

    @Autowired
    DeleteBookByIdService deleteBookByIdService;

    @RequestMapping("/main/deleteBookById/{bookId}")
    public String deleteBookById(@PathVariable("bookId") String bookId){

        Integer i = deleteBookByIdService.deleteBookById(bookId);//1：删除成功   0：删除失败

        return "redirect:/main/goBook";
    }

}
