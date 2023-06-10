package com.LW1_ptlb.controller.communicateController.communicateController;

import com.LW1_ptlb.service.communicateService.UpdateCommunicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//修改书籍推荐信息控制
@Controller
public class UpdateCommunicateController {

    //获得 修改书籍推荐信息控制
    @Autowired
    UpdateCommunicateService updateCommunicateService;

    @RequestMapping("/main/updateCommunicate")
    public String updateCommunicate(@RequestParam("bookCommunicateId") Integer bookCommunicateId, @RequestParam("bookCommunicateName") String bookCommunicateName, @RequestParam("bookCommunicateSynopsis") String bookCommunicateSynopsis, Model model){

        model.addAttribute("bookCommunicateId",bookCommunicateId);//书籍推荐id
        model.addAttribute("bookCommunicateName",bookCommunicateName);//书籍名
        model.addAttribute("bookCommunicateSynopsis",bookCommunicateSynopsis);//书籍简介

        Integer i = updateCommunicateService.updateCommunicate(bookCommunicateName, bookCommunicateSynopsis, bookCommunicateId);

        if (i.equals(1)){//更新成功
            return "redirect:/main/goMyCommunicate";
        }else if (i.equals(0)){//更新失败
            System.err.println("更新失败");
            model.addAttribute("msg","更新失败，请联系管理员");
            return "/communicate/updateCommunicate";
        }else {//更新异常
            System.err.println("更新异常");
            model.addAttribute("msg","更像异常，请联系管理员");
            return "/communicate/updateCommunicate";
        }

    }

}
