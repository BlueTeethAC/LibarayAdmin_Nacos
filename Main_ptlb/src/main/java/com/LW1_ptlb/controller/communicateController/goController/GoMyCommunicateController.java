package com.LW1_ptlb.controller.communicateController.goController;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.service.communicateService.GetCommunicateByUserNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

//跳转到我的书籍推荐页面
@Controller
public class GoMyCommunicateController {

    //根据用户名查询书籍推荐信息
    @Autowired
    GetCommunicateByUserNameService getCommunicateByUserNameService;

    //获得所有书籍推荐信息并且跳转到书籍推荐页面
    @RequestMapping("/main/goMyCommunicate")
    public String goCommunicate(Model model, HttpSession session){

        String loginUser = (String) session.getAttribute("loginUser");

        List<BookCommunicate> communicateByUserName = getCommunicateByUserNameService.getCommunicateByUserName(loginUser);

        System.out.println(communicateByUserName);

        model.addAttribute("communicateByUserName",communicateByUserName);

        return "/communicate/myCommunicate";
    }

}
