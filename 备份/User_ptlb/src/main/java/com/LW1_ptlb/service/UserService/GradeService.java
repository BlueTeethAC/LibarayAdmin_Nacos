package com.LW1_ptlb.service.UserService;

import com.LW1_ptlb.service.SQLService.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
//修改权限等级
public class GradeService {

    @Autowired
    UserDataService userDataService;

    //修改权限方法 返回 1 修改成功，返回 0 修改失败，返回 2 输入的权限超标
    public Integer updateGrade(String username,Integer grade){

        //权限只允许 0 和 1，2是最高管理员，无法直接授予，如果超出范围直接返回 2
        if (grade>1||grade<0){
            return 2;
        }

        //将数据放入 map
        Map<String,Object> map=new HashMap();
        map.put("username",username);
        map.put("grade",grade);

        Integer i=0;
        try{
            i = userDataService.updateUserGrade(map);//执行 updateUserGrade 方法
        }catch (Exception e){
            System.err.println("插入失败！\n"+e);//如果更新失败，抛出错误
        }

        if (i==1){
            System.out.println("更新成功！");
            return i;
        }else {
            System.err.println("更新失败！");
            return i;
        }

    }

}
