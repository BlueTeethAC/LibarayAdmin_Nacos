package com.LW1_ptlb.service.UserService;

import com.LW1_ptlb.mapper.UserDataMapper;
import com.LW1_ptlb.pojo.User;
import com.LW1_ptlb.service.SQLService.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectGradeByUserNameService {

    @Autowired
    UserDataService userDataService;

    //根据用户名查询到用户权限等级
    public Integer selectGrade(String username){

        User user = userDataService.selectUserByName(username);

        Integer grade = user.getGrade();

        System.out.println("用户："+user.getUserName()+" 的权限等级为："+grade+" 级");

        return grade;//返回权限等级，0：普通用户，1：管理员用户，2：最高管理员
    }
}
