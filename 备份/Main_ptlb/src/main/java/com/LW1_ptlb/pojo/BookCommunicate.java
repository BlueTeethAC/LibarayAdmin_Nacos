package com.LW1_ptlb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//书籍推荐实体类
public class BookCommunicate {

    Integer bookCommunicateId;//书籍推荐编号
    String bookCommunicateName;//推荐书籍名
    String bookCommunicateSynopsis;//书籍简介
    String bookCommunicatePicture;//书记封面链接
    String userName;//书籍推荐者用户名

}
