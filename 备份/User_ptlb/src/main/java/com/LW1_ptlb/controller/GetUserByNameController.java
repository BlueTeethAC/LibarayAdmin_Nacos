package com.LW1_ptlb.controller;

import com.LW1_ptlb.pojo.User;
import com.LW1_ptlb.service.SQLService.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//通过用户名获得 User 对象
@RestController
public class GetUserByNameController {

    //获得
    @Autowired
    UserDataService userDataService;

    //根据用户名获得 User 对象
    @RequestMapping("/getUserByName/{username}")
    public User getUserByName(@PathVariable("username") String username){

        User user = userDataService.selectUserByName(username);

        return user;
    }

}
