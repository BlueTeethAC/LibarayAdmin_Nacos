package com.LW1_ptlb.service.userService;

import com.LW1_ptlb.feign.User_ptlb_feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

//更新密码服务
@Service
public class UpdatePwdService {

    @Autowired
    GetUserService getUserService;

    //RestTemplate restTemplate = new RestTemplate();//获得 api 调用工具 restTemplate

    //获得 user_ptlb_feign 接口
    @Autowired
    User_ptlb_feign user_ptlb_feign;

    @ResponseBody//用 feign 方法需要 @Response
    public Integer updatePwd(String username,String password,String newPassword){

        //获得该用户的原密码
        String pwd=getUserService.getUser(username).getPwd();

        System.err.println("原密码："+pwd);
        System.err.println("输入的密码："+password);

        if (pwd.equals(password)){//如果原密码等于输入的密码

            //数据装入集合，后端接收的是 username 和 pwd
            //HashMap<String, String> map = new HashMap();
            //map.put("username",username);
            //map.put("password",newPassword);

            //编写链接
            //String apiLink="http://localhost:8081/LW1/User/updatePwd/{username}/{password}";

            //调用 api 接口，并且获得 json 对象 forEntity
            //ResponseEntity<String> forEntity = restTemplate.getForEntity(apiLink, String.class, map);

            //ReturnJackson 工具类，用于省略 json类型 转换为 json字符串 再 转换为 正常数据类型的过程
            //ReturnJackson returnJackson = new ReturnJackson();//实例化工具类  ReturnJackson
            //Integer i = returnJackson.returnJackson(forEntity,Integer.class);//把 json 对象转换为所需要的数据类型，returnJackson({获得到的 json 类型（不是 json 字符串，直接放入即可）},{需要的数据类型.class})

            //调用 updatePwdFeign 方法，修改密码
            Integer i = user_ptlb_feign.updatePwdFeign(username, newPassword);//修改密码，返回 1，密码修改成功，返回 0，密码修改失败

            return i;//修改密码，返回 1，密码修改成功，返回 0，密码修改失败

        }else {
            return 2;//返回2，原密码与现密码不一致
        }


    }

}
