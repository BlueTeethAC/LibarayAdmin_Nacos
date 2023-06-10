package com.LW1_ptlb.controller.communicateController.goController;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.pojo.UserComments;
import com.LW1_ptlb.service.commentsService.GetAllCommentsService;
import com.LW1_ptlb.service.communicateService.GetAllCommunicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//跳转到书籍推荐页面控制
@Controller
public class GoCommunicateController {

    //获得所有书籍推荐信息
    @Autowired
    GetAllCommunicateService getAllComments;

    //获得所有书籍推荐信息并且跳转到书籍推荐页面
    @RequestMapping("/main/goCommunicate")
    public String goCommunicate(Model model){
        List<BookCommunicate> allCommunicate = getAllComments.getAllCommunicate();
        model.addAttribute("allCommunicate",allCommunicate);
        System.out.println(allCommunicate);
        return "/communicate/communicate";
    }

}
