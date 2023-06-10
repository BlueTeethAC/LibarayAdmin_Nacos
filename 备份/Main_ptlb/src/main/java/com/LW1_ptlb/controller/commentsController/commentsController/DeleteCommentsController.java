package com.LW1_ptlb.controller.commentsController.commentsController;

import com.LW1_ptlb.service.commentsService.DeleteUserCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//删除评论服务
@Controller
public class DeleteCommentsController {

    //获得删除用户评论服务
    @Autowired
    DeleteUserCommentsService deleteUserCommentsService;

    @RequestMapping("/main/deleteComments/{commentsId}/{bookCommunicateId}")
    public String deleteComments(@PathVariable("commentsId") Integer commentsId,@PathVariable("bookCommunicateId") Integer bookCommunicateId){
        Integer i = deleteUserCommentsService.deleteUserComments(commentsId);

        if (i.equals(1)){
            System.out.println("评论删除成功");
        }else if(i.equals(0)){
            System.err.println("评论删除失败");
        }else {
            System.err.println("评论删除异常");
        }

        return "redirect:/main/goCommunicateRead/"+bookCommunicateId;

    }

}
