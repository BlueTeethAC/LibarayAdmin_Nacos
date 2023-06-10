package com.LW1_ptlb.service.userService;

import com.LW1_ptlb.feign.User_ptlb_feign;
import com.LW1_ptlb.pojo.User;
import com.LW1_ptlb.utils.ReturnJackson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//获得所有用户服务
@Service
public class GetAllUserService {

    //RestTemplate restTemplate = new RestTemplate();//获得 api 调用工具 restTemplate

    //获得 user_ptlb_feign 接口
    @Autowired
    User_ptlb_feign user_ptlb_feign;

    //获得所有用户
    @ResponseBody//用 feign 方法需要 @Response
    public List<User> getAllUser(){

        //编写链接
        //String apiLink="http://localhost:8081/LW1/User/selectAllUser";

        //调用 api 接口，并且获得 json 对象 forEntity
        //ResponseEntity<String> forEntity = restTemplate.getForEntity(apiLink, String.class);

        //ReturnJackson 工具类，用于省略 json类型 转换为 json字符串 再 转换为 正常数据类型的过程
        //ReturnJackson returnJackson = new ReturnJackson();//实例化工具类  ReturnJackson
        //<User> user= returnJackson.returnJackson(forEntity,List.class);//把 json 对象转换为所需要的数据类型，returnJackson({获得到的 json 类型（不是 json 字符串，直接放入即可）},{需要的数据类型.class})

        List<User> user = user_ptlb_feign.getAllUserFeign();//获得所有用户

        return user;//返回值（所有有效用户）
    }

}
