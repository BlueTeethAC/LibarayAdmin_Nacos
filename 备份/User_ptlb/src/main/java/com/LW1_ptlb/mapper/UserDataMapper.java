package com.LW1_ptlb.mapper;

import com.LW1_ptlb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
//@Mapper 注解：表示了这是一个 mybatis 的 mapper 类     是 Dao 层的
//@Repository用在持久层的接口上，这个注解是将接口的一个实现类交给spring管理，与 @Controller，@Service 等注解 作用一样
public interface UserDataMapper {

    //查询所有用户
    List<User> selectAllUser();

    //根据 用户名 查询用户
    User selectUserByName(String username);

    //根据 用户名 查询用户（包含已删除的）
    User selectUserByName3(String username);

    //根据 用户名 查询用户（模糊查询）
    List<User> selectUserByName2(String username);

    //新增用户
    Integer addUser(User user);

    //修改用户（改权限）
    Integer updateUserGrade(Map map);

    //修改用户（改密码）
    Integer updateUserPwd(Map map);

    //删除用户 把 用户的状态改为 0，不是去删除
    Integer deleteUser(String username);

}
