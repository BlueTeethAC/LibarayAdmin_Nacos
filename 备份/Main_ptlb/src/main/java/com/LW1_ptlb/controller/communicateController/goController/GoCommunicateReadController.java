package com.LW1_ptlb.controller.communicateController.goController;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.pojo.UserComments;
import com.LW1_ptlb.service.commentsService.GetUserCommentsByBookIdService;
import com.LW1_ptlb.service.communicateService.GetCommunicateByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//跳转到书籍推荐阅读界面
@Controller
public class GoCommunicateReadController {

    //获得根据书籍推荐id 查询书籍推荐服务
    @Autowired
    GetCommunicateByIdService getCommunicateByIdService;

    //按照书籍推荐编号查询对应书籍的所有评论
    @Autowired
    GetUserCommentsByBookIdService getUserCommentsByBookIdService;

    @RequestMapping("/main/goCommunicateRead/{bookCommunicateId}")
    public String goCommunicateById(@PathVariable("bookCommunicateId") Integer bookCommunicateId, Model model){

        //根据id 获得 书籍推荐
        BookCommunicate communicateById = getCommunicateByIdService.getCommunicateById(bookCommunicateId);

        //System.out.println(communicateById);

        System.out.println("来过了");

        model.addAttribute("bookCommunicateId",communicateById.getBookCommunicateId());//书籍推荐编号
        model.addAttribute("bookCommunicateName",communicateById.getBookCommunicateName());//推荐书籍名
        model.addAttribute("bookCommunicateSynopsis",communicateById.getBookCommunicateSynopsis());//书籍简介
        model.addAttribute("bookCommunicatePicture",communicateById.getBookCommunicatePicture());//书籍封面链接
        model.addAttribute("userName",communicateById.getUserName());//书籍推荐者用户名


        //获取对应的评论
        List<UserComments> userCommentsByBookId = getUserCommentsByBookIdService.getUserCommentsByBookId(bookCommunicateId);
        //将评论返回给前端
        model.addAttribute("userComments",userCommentsByBookId);

        return "/communicate/communicateRead";
    }

}
