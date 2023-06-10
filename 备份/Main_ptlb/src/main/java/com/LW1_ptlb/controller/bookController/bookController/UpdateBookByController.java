package com.LW1_ptlb.controller.bookController.bookController;

import com.LW1_ptlb.service.bookService.UpdateBookByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//根据 具体书本id 修改书本状态
@Controller
public class UpdateBookByController {

    //获得 根据 具体书本id 修改书本状态 服务
    @Autowired
    UpdateBookByIdService updateBookByIdService;

    @RequestMapping("/main/updateBookById")
    public String updateBook(@RequestParam("bookId") String bookId, @RequestParam("borrowStatus") Integer borrowStatus, Model model){

        //调用修改 具体书本状态 的方法
        Integer i = updateBookByIdService.updateBookById(bookId, borrowStatus);
        //修改失败    1：修改成功   2：输入的状态代码 borrowStatus 不正确

        if (i.equals(1)){//修改成功
            System.out.println("修改成功！");
            return "redirect:/main/goBook";
        }else if(i.equals(2)){
            System.out.println("输入的状态代码 borrowStatus 不正确！");
            model.addAttribute("msg","输入的状态代码不正确！");
            return "/book/updateBook";
        }else {
            System.out.println("修改失败！请联系管理员");
            model.addAttribute("msg","修改失败！请联系管理员");
            return "/book/updateBook";
        }
    }
}
