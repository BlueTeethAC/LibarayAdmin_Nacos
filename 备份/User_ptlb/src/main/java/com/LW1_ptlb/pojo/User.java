package com.LW1_ptlb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userId;//用户 id
    private String userName;//用户名
    private String pwd;//密码
    private int grade;//权限等级

}
