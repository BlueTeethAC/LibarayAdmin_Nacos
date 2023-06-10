package com.LW1_ptlb.service.userService;

import com.LW1_ptlb.feign.User_ptlb_feign;
import com.LW1_ptlb.utils.ReturnJackson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

//登陆服务
@Service
public class LoginService {

    //RestTemplate restTemplate = new RestTemplate();//获得 api 调用工具 restTemplate


    //获得 user_ptlb_feign 接口
    @Autowired
    User_ptlb_feign user_ptlb_feign;


    //调用 localhost:8081/LW1/User/Login/{用户名}/{密码} API，验证密码
    @ResponseBody//用 feign 方法需要 @Response
    public Integer login(String username,String password) {

        //数据装入集合，后端接收的是 username 和 pwd
        //HashMap<String, String> map = new HashMap();
        //map.put("username",username);
        //map.put("password",password);

        //编写链接
        //String apiLink="http://localhost:8081/LW1/User/Login/{username}/{password}";

        //调用 api 接口，并且获得 json 对象 forEntity
        //ResponseEntity<String> forEntity = restTemplate.getForEntity(apiLink, String.class, map);

        //ReturnJackson 工具类，用于省略 json类型 转换为 json字符串 再 转换为 正常数据类型的过程
        //ReturnJackson returnJackson = new ReturnJackson();//实例化工具类  ReturnJackson
        //Integer i = returnJackson.returnJackson(forEntity,Integer.class);//把 json 对象转换为所需要的数据类型，returnJackson({获得到的 json 类型（不是 json 字符串，直接放入即可）},{需要的数据类型.class})

        //调用 loginfeign 方法验证登录
        Integer i = user_ptlb_feign.loginFeign(username, password);//返回 1 登陆成功，返回 0 密码错误，返回 2 用户名不存在

        return i;//返回值
        //返回 1 登陆成功，返回 0 密码错误，返回 2 用户名不存在

    }

}
