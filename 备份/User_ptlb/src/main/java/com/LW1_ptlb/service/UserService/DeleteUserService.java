package com.LW1_ptlb.service.UserService;

import com.LW1_ptlb.mapper.UserDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {

    @Autowired
    UserDataMapper userDataMapper;

    public Integer deleteUser(String username){

        Integer i=0;

        try{
            i = userDataMapper.deleteUser(username);//删除用户（把用户状态从 1 改为 0）
        }catch (Exception e){
            System.err.println("修改失败！\n"+e);
        }

        if (i==1){
            System.out.println("删除成功！");//删除成功则返回 1，删除失败返回 0
            return i;
        }else {
            System.err.println("删除失败！");
            return i;
        }

    }

}
