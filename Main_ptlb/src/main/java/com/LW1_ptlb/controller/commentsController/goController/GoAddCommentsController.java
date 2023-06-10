package com.LW1_ptlb.controller.commentsController.goController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


//新增书籍评论控制
@Controller
public class GoAddCommentsController {

    @RequestMapping("/main/goAddUserComments/{bookCommunicateId}/{bookCommunicateName}/{userName}")
    public String addUserComments(@PathVariable("bookCommunicateId") Integer bookCommunicateId,@PathVariable("bookCommunicateName") String bookCommunicateName,@PathVariable("userName") String userName, Model model){

        model.addAttribute("bookCommunicateId",bookCommunicateId);//书籍推荐id
        model.addAttribute("bookCommunicateName",bookCommunicateName);//书籍推荐名
        model.addAttribute("userName",userName);//书籍推荐人

        return "/communicate/addComments";
    }

}
