package com.LW1_ptlb.controller;

import com.LW1_ptlb.pojo.User;
import com.LW1_ptlb.service.SQLService.UserDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//查询所有用户
@RestController
public class SelectAllController {

    @Autowired
    UserDataService userDataService;

    //查询所有用户
    @RequestMapping("/selectAllUser")
    public List<User> SelectAllUser() throws JsonProcessingException {

        List<User> users = userDataService.selectAllUser();

        return users;

    }

}
