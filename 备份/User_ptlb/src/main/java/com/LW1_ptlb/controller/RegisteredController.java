package com.LW1_ptlb.controller;

import com.LW1_ptlb.service.LoginService.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisteredController {

    //获取 registeredService 注册服务
    @Autowired
    RegisteredService registeredService;

    //restful 风格接收用户名和密码
    @RequestMapping("/Register/{username}/{pwd}")
    public Integer registeredController(@PathVariable("username") String username,@PathVariable("pwd") String pwd){

        //给 map 中填入接收的数据
        Map<String,String> map=new HashMap();
        map.put("username",username);
        map.put("pwd",pwd);


        Integer i = registeredService.Registered(map);//执行注册服务，0为注册失败，1为注册成功

        return i;
    }

}
