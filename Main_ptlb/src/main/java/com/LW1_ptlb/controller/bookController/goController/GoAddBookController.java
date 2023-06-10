package com.LW1_ptlb.controller.bookController.goController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoAddBookController {

    //跳转到添加具体书本信息页面
    @RequestMapping("/main/goAddBook")
    public String goAddBook(){
        return "/book/addBook";
    }

}
