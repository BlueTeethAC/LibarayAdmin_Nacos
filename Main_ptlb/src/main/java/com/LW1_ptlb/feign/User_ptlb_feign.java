package com.LW1_ptlb.feign;

import com.LW1_ptlb.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//用户模块接口调用
@FeignClient("UserPtlb")//需要的服务名 User_ptlb
@RestController//fegin 本质还是发送请求，所以需要
public interface User_ptlb_feign {

    //按照用户名删除用户 feign
    @RequestMapping("/LW1/User/deleteUser/{username}")
    Integer deleteUserByNameFeign(@PathVariable("username") String username);
    //删除成功则返回 1，删除失败返回 0


    //获得所有用户 feign
    @RequestMapping("/LW1/User/selectAllUser")
    List<User> getAllUserFeign();
    //返回值（所有有效用户），也就是状态为 1 的用户


    //根据 用户名 查询用户（模糊查询）
    @RequestMapping("/LW1/User/selectUserByName/{userName}")
    List<User> getUserByNameFeign(@PathVariable("userName") String userName);
    //根据 用户名 查询用户（模糊查询）


    //根据用户名获得用户权限等级 feign
    @RequestMapping("/LW1/User/selectGrade/{username}")
    Integer getGradeFeign(@PathVariable("username") String username);
    //返回值 0为普通用户，1为管理员，2为最高管理员


    //通过用户名获得 User 对象 feign
    @RequestMapping("/LW1/User/getUserByName/{username}")
    User getUserFeign(@PathVariable("username") String username);
    //返回值，返回查到的用户


    //登陆服务 调用 localhost:8081/LW1/User/Login/{用户名}/{密码} API，验证密码
    @RequestMapping("/LW1/User/Login/{username}/{password}")
    Integer loginFeign(@PathVariable("username") String username,@PathVariable("password") String password);
    //返回 1 登陆成功，返回 0 密码错误，返回 2 用户名不存在


    //调用 localhost:8081/LW1/User/Register/{用户名}/{密码} 进行注册
    @RequestMapping("/LW1/User/Register/{username}/{password}")
    Integer registerFeign(@PathVariable("username") String username,@PathVariable("password") String password);
    //返回 1 注册成功，返回 0 插注册失败


    //修改权限服务，修改权限方法 返回 1 修改成功，返回 0 修改失败，返回 2 输入的权限超标
    @RequestMapping("/LW1/User/updateGrade/{username}/{grade}")
    Integer updateGradeFeign(@PathVariable("username") String username,@PathVariable("grade") Integer grade);
    //返回 1 修改成功，返回 0 修改失败，返回 2 输入的权限超标


    //更新密码服务
    @RequestMapping("/LW1/User/updatePwd/{username}/{password}")
    Integer updatePwdFeign(@PathVariable("username") String username,@PathVariable("password") String newPassword);
    //修改密码，返回 1，密码修改成功，返回 0，密码修改失败，返回2，原密码与现密码不一致

}
