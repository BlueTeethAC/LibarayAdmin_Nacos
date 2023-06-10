package com.LW1_ptlb.controller.communicateController.communicateController;

import com.LW1_ptlb.service.communicateService.DeleteCommunicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//根据书籍推荐id删除书籍推荐
@Controller
public class DeleteCommunicateController {

    //获得 根据书籍推荐id删除书籍推荐 服务
    @Autowired
    DeleteCommunicateService deleteCommunicateService;

    @RequestMapping("/main/deleteCommunicate/{bookCommunicateId}")
    public String deleteCommunicate(@PathVariable("bookCommunicateId") Integer bookCommunicateId){

        Integer i = deleteCommunicateService.deleteCommunicate(bookCommunicateId);

        if (i.equals(0)){
            System.err.println("删除失败");
        }else if (i.equals(1)){
            System.out.println("删除成功");
        }else {
            System.err.println("删除异常");
        }

        return "redirect:/main/goCommunicate";

    }

}
