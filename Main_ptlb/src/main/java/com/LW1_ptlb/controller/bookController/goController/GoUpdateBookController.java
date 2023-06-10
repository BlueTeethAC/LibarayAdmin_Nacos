package com.LW1_ptlb.controller.bookController.goController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//跳转到 修改具体书本 页面
@Controller
public class GoUpdateBookController {

    @RequestMapping("/main/updateBookById/{bookId}/{borrowStatus}")
    public String goUpdateBookById(@PathVariable("bookId") String bookId, @PathVariable("borrowStatus") Integer borrowStatus, Model model){

        model.addAttribute("bookId",bookId);
        model.addAttribute("borrowStatus",borrowStatus);

        return "/book/updateBook";
    }

}
