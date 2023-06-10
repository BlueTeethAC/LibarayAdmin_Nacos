package com.LW1_ptlb.service.LoginService;

import com.LW1_ptlb.pojo.User;
import com.LW1_ptlb.service.SQLService.UserDataService;
import com.LW1_ptlb.utils.DateGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Random;

//用户注册服务
@Service
public class RegisteredService {

    @Autowired
    UserDataService userDataService;


    //注册方法
    public Integer Registered(Map<String,String> map){

        //查询用户名是否已经存在
        String username= map.get("username");

        //去数据库中查询是否有此用户
        User user1 = userDataService.selectUserByName3(username);
        if (!(user1==null)){//如果能查到用户
            return 2;//返回 2，表示用户名已经存在
        }


        String id=getDateNum()+getRandomNum();//生成用户id
        int userid= Integer.parseInt(id);//转换为 int 类型
        System.out.println("=============================================");
        User user = new User(userid, map.get("username"), map.get("pwd"), 0);//生成 User 类
        System.out.println(user);


        Integer i = 0;
        try {
            i = userDataService.addUser(user);//执行插入操作
        } catch (Exception e) {
            System.err.println("插入失败！\n"+e);//如果插入失败，抛出错误
        }

        if (i==1){
            System.out.println("注册成功！");
            return i;
        }else{
            System.err.println("注册失败！");
            return i;
        }

    }



    //获得 2 位随机数
    private String getRandomNum(){

        Random random = new Random();
        int i = random.nextInt(99);//生成一个 0~99 之间的随机数
        String s = String.valueOf(i);//把随机数转换为 String 类型
        System.out.println(s);
        return s;
    }

    //获得当前日期，格式为 YYYYMMdd
    private String getDateNum(){
        //生成用户 id
        DateGenerated dateGenerated = new DateGenerated();
        String nowDate = dateGenerated.getNowDate();//获得当前日期，格式为 YYYYMMdd
        return nowDate;
    }

}
