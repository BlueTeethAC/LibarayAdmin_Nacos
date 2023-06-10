package com.LW1_ptlb.controller.communicateController.goController;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.service.communicateService.GetCommunicateByIdService;
import com.LW1_ptlb.service.communicateService.UpdateCommunicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

//跳转到修改书籍推荐页面控制
@Controller
public class GoUpdateCommunicateController {

    //获得根据id查询书记推荐信息服务
    @Autowired
    GetCommunicateByIdService getCommunicateByIdService;

    @RequestMapping("/main/goUpdateCommunicate/{bookCommunicateId}")
    public String goUpdateCommunicate(@PathVariable("bookCommunicateId") Integer bookCommunicateId, Model model){

        BookCommunicate communicate = getCommunicateByIdService.getCommunicateById(bookCommunicateId);

        model.addAttribute("bookCommunicatePicture",communicate.getBookCommunicatePicture());//书籍封面
        model.addAttribute("bookCommunicateId",communicate.getBookCommunicateId());//书籍推荐id
        model.addAttribute("bookCommunicateName",communicate.getBookCommunicateName());//书籍推荐名
        model.addAttribute("bookCommunicateSynopsis",communicate.getBookCommunicateSynopsis());//书籍简介

        return "/communicate/updateCommunicate";

    }

}
