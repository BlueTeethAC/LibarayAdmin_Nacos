package com.LW1_ptlb.controller;

import com.LW1_ptlb.service.UserService.PwdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//修改用户密码
@RestController
public class PwdController {

    @Autowired
    PwdService pwdService;

    @RequestMapping("/updatePwd/{username}/{pwd}")
    public Integer pwdController(@PathVariable("username") String username,@PathVariable("pwd") String pwd){

        Integer i = pwdService.updatePwd(username, pwd);

        return i;//修改密码，返回 1，密码修改成功，返回 0，密码修改失败
    }

}
