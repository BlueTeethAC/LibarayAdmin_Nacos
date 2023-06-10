package com.LW1_ptlb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//图书存量
public class BookCount {

    private Integer bookNameId;//书名 id
    private String bookName;// 书名
    private String bookPlace;// 图书存放位置 书柜号+L+行号（例：AL1）
    private float bookPrice;//书本单价
    private Integer maxNum;//书本最大数量
    private Integer nowNum;//书本当前数量

}
