package com.LW1_ptlb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//用户评论实体类
public class UserComments {

    Integer commentsId;//书籍评论编号
    String userName;//用户名
    String userComments;//用户评论
    Date commentsDate;//评论日期
    Integer bookCommunicateId;//书籍推荐编号

}
