package com.LW1_ptlb.service.userService;

import com.LW1_ptlb.feign.User_ptlb_feign;
import com.LW1_ptlb.utils.ReturnJackson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

//修改权限服务
@Service
public class UpdateGradeService {

    //RestTemplate restTemplate = new RestTemplate();//获得 api 调用工具 restTemplate


    //获得 user_ptlb_feign 接口
    @Autowired
    User_ptlb_feign user_ptlb_feign;

    @ResponseBody//用 feign 方法需要 @Response
    public Integer updateGrade(String username,Integer grade){

        //数据装入集合，后端接收的是 username 和 pwd
        //HashMap<String, Object> map = new HashMap();
        //map.put("username",username);
        //map.put("grade",grade);

        //编写链接
        //String apiLink="http://localhost:8081/LW1/User/updateGrade/{username}/{grade}";

        //调用 api 接口，并且获得 json 对象 forEntity
        //ResponseEntity<String> forEntity = restTemplate.getForEntity(apiLink, String.class, map);

        //ReturnJackson 工具类，用于省略 json类型 转换为 json字符串 再 转换为 正常数据类型的过程
        //ReturnJackson returnJackson = new ReturnJackson();//实例化工具类  ReturnJackson
        //Integer i = returnJackson.returnJackson(forEntity,Integer.class);//把 json 对象转换为所需要的数据类型，returnJackson({获得到的 json 类型（不是 json 字符串，直接放入即可）},{需要的数据类型.class})

        //调用 updateGradeFeign 方法，修改权限等级
        Integer i = user_ptlb_feign.updateGradeFeign(username, grade);//修改权限方法 返回 1 修改成功，返回 0 修改失败，返回 2 输入的权限超标

        return i;//修改权限方法 返回 1 修改成功，返回 0 修改失败，返回 2 输入的权限超标

    }

}
