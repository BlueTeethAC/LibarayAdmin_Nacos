package com.LW1_ptlb.service.SQLService;

import com.LW1_ptlb.mapper.UserDataMapper;
import com.LW1_ptlb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserDataService implements UserDataMapper{

    @Autowired
    UserDataMapper userDataMapper;

    //查询所有用户
    public List<User> selectAllUser(){
        return userDataMapper.selectAllUser();
    };

    //根据 用户名 查询用户
    public User selectUserByName(String username){
        return userDataMapper.selectUserByName(username);
    };

    //根据 用户名 查询用户（包含已经删除的）
    public User selectUserByName3(String username){
        return userDataMapper.selectUserByName3(username);
    };

    //根据 用户名 查询用户（模糊查询）
    public List<User> selectUserByName2(String username){
        return userDataMapper.selectUserByName2(username);
    }

    //新增用户
    public Integer addUser(User user){
        return userDataMapper.addUser(user);
    };

    //修改用户（改权限）
    public Integer updateUserGrade(Map map){
        return userDataMapper.updateUserGrade(map);
    };

    //修改用户（改密码）
    public Integer updateUserPwd(Map map){
        return userDataMapper.updateUserPwd(map);
    };

    //删除用户 把 用户的状态改为 0，不是去删除
    public Integer deleteUser(String username){
        return userDataMapper.deleteUser(username);
    };

}
