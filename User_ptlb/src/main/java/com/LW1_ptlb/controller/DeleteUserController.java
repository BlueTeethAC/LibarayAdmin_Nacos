package com.LW1_ptlb.controller;

import com.LW1_ptlb.service.UserService.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//删除用户
@RestController
public class DeleteUserController {

    @Autowired
    DeleteUserService deleteUserService;

    @RequestMapping("/deleteUser/{username}")
    public Integer deleteUser(@PathVariable("username") String username){

        Integer i = deleteUserService.deleteUser(username);//删除成功则返回 1，删除失败返回 0

        return i;

    }

}
