package com.LW1_ptlb.controller;

import com.LW1_ptlb.service.UserService.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
//修改用户权限
public class GradeController {

    @Autowired
    GradeService gradeService;

    //修改用户权限
    @RequestMapping(value = "/updateGrade/{username}/{grade}",method = RequestMethod.GET)
    public Integer updateGrade(@PathVariable("username") String username,@PathVariable("grade") Integer grade){

        Integer i = gradeService.updateGrade(username, grade);//调用 updateGrade 方法

        return i;//修改权限方法 返回 1 修改成功，返回 0 修改失败，返回 2 输入的权限超标
    }

}
