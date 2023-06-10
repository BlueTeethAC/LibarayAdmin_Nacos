package com.LW1_ptlb.controller.commentsController.commentsController;

import com.LW1_ptlb.service.commentsService.AddUserCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

//添加书籍推荐评论控制
@Controller
public class AddCommentsController {

    //获得添加书籍推荐评论服务
    @Autowired
    AddUserCommentsService addUserCommentsService;

    @RequestMapping("/main/addUserComments")
    public String addUserComments(@RequestParam("bookCommunicateId") Integer bookCommunicateId, @RequestParam("userComments") String userComments,@RequestParam("userName") String userName, @RequestParam("bookCommunicateName") String bookCommunicateName,HttpSession session, Model model){

        //获得当前用户名字
        String loginUser = (String) session.getAttribute("loginUser");

        //添加评论
        Integer i = addUserCommentsService.addUserComments(loginUser, userComments, bookCommunicateId);

        if (i.equals(0)){//评论失败
            System.err.println("评论失败，请联系管理员！");
            model.addAttribute("msg","评论失败，请联系管理员！");
            model.addAttribute("bookCommunicateId",bookCommunicateId);
            model.addAttribute("userComments",userComments);
            model.addAttribute("userName",userName);
            model.addAttribute("bookCommunicateName",bookCommunicateName);
            return "/communicate/addComments";
        }else {//评论成功
            return "redirect:/main/goCommunicateRead/"+bookCommunicateId;
        }

    }

}
