package com.LW1_ptlb.controller.bookAdminController.goController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//跳转到 修改图书存量信息界面
@Controller
public class GoUpdateBookAdminController {

    @RequestMapping("/main/goUpdateBookAdmin/{bookNameId}/{bookName}/{bookPlace}/{bookPrice}/{maxNum}")
    public String goUpdateBookAdmin(@PathVariable("bookNameId") Integer bookNameId, @PathVariable("bookName") String bookName, @PathVariable("bookPlace") String bookPlace, @PathVariable("bookPrice") float bookPrice, @PathVariable("maxNum") Integer maxNum, Model model){

        //从第一个字符截取到第二个字符，包括第一个字符，但是不包括第二个字符
        String bookPlace1=bookPlace.substring(0,1);
        System.out.println(bookPlace1);

        //从第二个字符开始截取，不包括第二个字符
        String bookPlace2=bookPlace.substring(2);
        System.out.println(bookPlace2);

        model.addAttribute("bookNameId",bookNameId);
        model.addAttribute("bookName",bookName);
        model.addAttribute("bookPlace1",bookPlace1);
        model.addAttribute("bookPlace2",bookPlace2);
        model.addAttribute("bookPrice",bookPrice);
        model.addAttribute("maxNum",maxNum);

        return "/bookAdmin/updateBookAdmin";
    }

}
