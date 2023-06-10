package com.LW1_ptlb.service.userService;

import com.LW1_ptlb.feign.User_ptlb_feign;
import com.LW1_ptlb.utils.ReturnJackson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

//注册服务
@Service
public class RegisterService {

    //获得工具类 RestTemplate
    //RestTemplate restTemplate=new RestTemplate();


    //获得 user_ptlb_feign 接口
    @Autowired
    User_ptlb_feign user_ptlb_feign;


    //调用 localhost:8081/LW1/User/Register/{用户名}/{密码} 进行注册
    @ResponseBody//用 feign 方法需要 @Response
    public Integer register(String username,String password){

        //创建 hashmap 集合，放入数据
        //HashMap<String, String> map = new HashMap<>();
        //map.put("username",username);
        //map.put("password",password);

        //编写链接
        //String url="http://localhost:8081/LW1/User/Register/{username}/{password}";

        //获得 JSON 对象
        //ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class, map);

        ////ReturnJackson 工具类，用于省略 json类型 转换为 json字符串 再 转换为 正常数据类型的过程
        //ReturnJackson returnJackson = new ReturnJackson();//实例化工具类  ReturnJackson

        //Integer i = returnJackson.returnJackson(forEntity, Integer.class);//返回 1 注册成功，返回 0 插注册失败

        //调用 registerFeign 方法，进行注册
        Integer i = user_ptlb_feign.registerFeign(username, password);//返回 1 注册成功，返回 0 插注册失败

        return i;//返回 1 注册成功，返回 0 插注册失败

    }

}
