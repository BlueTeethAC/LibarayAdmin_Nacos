package com.LW1_ptlb.controller;

import com.LW1_ptlb.service.UserService.SelectGradeByUserNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//根据用户名查询用户权限等级
@RestController
public class SelectGradeByUserNameController {

    @Autowired
    SelectGradeByUserNameService selectGrade;

    @RequestMapping("/selectGrade/{username}")
    public Integer selectGrade(@PathVariable("username") String username){

        Integer i = selectGrade.selectGrade(username);//按照用户名查询用户权限等级

        return i;//返回权限等级，0：普通用户，1：管理员用户，2：最高管理员

    }

}
