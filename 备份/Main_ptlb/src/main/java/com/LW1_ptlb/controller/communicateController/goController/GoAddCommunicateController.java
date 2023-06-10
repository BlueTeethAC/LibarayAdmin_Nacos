package com.LW1_ptlb.controller.communicateController.goController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//跳转到新增书籍推荐页面
@Controller
public class GoAddCommunicateController {

    @RequestMapping("/main/goAddCommunicate")
    public String goAddCommunicate(){
        return "/communicate/addCommunicate";
    }

}
