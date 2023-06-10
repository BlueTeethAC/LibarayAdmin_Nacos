package com.LW1_ptlb.service.UserService;

import com.LW1_ptlb.service.SQLService.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
//修改用户密码
public class PwdService {

    @Autowired
    UserDataService userDataService;

    public Integer updatePwd(String username,String pwd){

        //把数据装入 map
        Map<String,String> map=new HashMap();
        map.put("username",username);
        map.put("pwd",pwd);

        Integer i=0;

        try{
            i = userDataService.updateUserPwd(map);
        }catch (Exception e){
            System.err.println("更新失败！\n"+e);
        }

        //修改密码，返回 1，密码修改成功，返回 0，密码修改失败
        if (i==1){
            System.out.println("密码更新成功！");
            return i;
        }else{
            System.err.println("密码更新失败!");
            return i;
        }

    }
}
