package com.LW1_ptlb.controller;

import com.LW1_ptlb.pojo.User;
import com.LW1_ptlb.service.SQLService.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//根据 用户名 查询用户（模糊查询）
@RestController
public class SelectUserByName2Controller {

    //根据 用户名 查询用户（模糊查询）
    @Autowired
    UserDataService userDataService;

    @RequestMapping("/selectUserByName/{userName}")
    public List<User> selectUserByName(@PathVariable("userName") String userName){
        List<User> user = userDataService.selectUserByName2(userName);
        return user;
    }

}
