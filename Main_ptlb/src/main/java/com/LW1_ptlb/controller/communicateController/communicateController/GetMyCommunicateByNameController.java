package com.LW1_ptlb.controller.communicateController.communicateController;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.service.communicateService.GetCommunicateByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

//按照推荐的书籍名查询固定用户的书籍推荐（用户名固定，书籍名为模糊查询）
@Controller
public class GetMyCommunicateByNameController {

    //获得 按照推荐的书籍名查询固定用户的书籍推荐（用户名固定，书籍名为模糊查询） 服务
    @Autowired
    GetCommunicateByNameService getCommunicateByNameService;

    @RequestMapping("/main/getCommunicateByName")
    public String getCommunicateByName(@RequestParam("selectBook") String bookName, HttpSession session, Model model){

        //将搜索的字符串保存返回给前端
        model.addAttribute("selectBook",bookName);


        //如果输入的参数为空
        if (bookName.equals("")){
            return "redirect:/main/goMyCommunicate";
        }

        //获得用户名
        String userName = (String) session.getAttribute("loginUser");

        List<BookCommunicate> communicateByName = getCommunicateByNameService.getCommunicateByName(bookName, userName);

        System.err.println(communicateByName);

        //将搜索的结果返回给前端
        model.addAttribute("communicateByUserName",communicateByName);

        return "/communicate/myCommunicate";
    }

}
