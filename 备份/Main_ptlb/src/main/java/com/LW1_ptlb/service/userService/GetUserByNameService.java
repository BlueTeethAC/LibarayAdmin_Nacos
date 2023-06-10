package com.LW1_ptlb.service.userService;

import com.LW1_ptlb.feign.User_ptlb_feign;
import com.LW1_ptlb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//根据 用户名 查询用户（模糊查询）
@Service
public class GetUserByNameService {

    //获得 User_ptlb_feign 接口
    @Autowired
    User_ptlb_feign user_ptlb_feign;

    @ResponseBody
    public List<User> getUserByName(String userName){
        List<User> userByNameFeign = user_ptlb_feign.getUserByNameFeign(userName);
        return userByNameFeign;
    }

}
