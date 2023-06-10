package com.LW1_ptlb.controller.communicateController.communicateController;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.service.communicateService.GetCommunicateByBookNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//按照推荐的书籍名查询书籍推荐（模糊查询）
@Controller
public class GetCommunicateByBookNameController {

    //获得 按照推荐的书籍名查询书籍推荐（模糊查询） 服务
    @Autowired
    GetCommunicateByBookNameService getCommunicateByBookNameService;

    @RequestMapping("/main/getCommunicateByBookName")
    public String getCommunicateByBookName(@RequestParam("selectBook") String bookName, Model model){

        if (bookName.equals("")){//如果输入的参数为空
            return "redirect:/main/goCommunicate";
        }

        model.addAttribute("selectBook",bookName);//加搜索的字符串保存回去

        List<BookCommunicate> communicateByBookName = getCommunicateByBookNameService.getCommunicateByBookName(bookName);
        model.addAttribute("allCommunicate",communicateByBookName);//将搜索的结构返回给前端
        System.out.println(communicateByBookName);
        return "/communicate/communicate";
    }
}
