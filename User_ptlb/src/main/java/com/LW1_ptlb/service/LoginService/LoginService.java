package com.LW1_ptlb.service.LoginService;

import com.LW1_ptlb.pojo.User;
import com.LW1_ptlb.service.SQLService.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//登录服务
@Service
public class LoginService {

    @Autowired
    UserDataService userDataService;

    //登录方法：返回 1 登陆成功，返回 0 密码错误，返回 2 用户名不存在
    public int Login(String username,String pwd){
        User user = userDataService.selectUserByName(username);
        if (user==null){//找不到用户名时
            return 2;
        }else if(user.getPwd().equals(pwd)){//密码正确时
            return 1;
        }else{//密码错误时
            return 0;
        }
    }

}
