package com.LW1_ptlb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//具体书本信息
public class Book {

    //private String contextId;//具体书本编号 和 书名编号 的 关系id
    private Integer bookNameId;//书名id
    private String bookName;//书名
    private String bookId;//图书编号  书名 id + A + 同书名第几本 （例：001A001）
    private Integer borrowStatus;//0：未出借 1：出借 2：逾期未还 3：损坏/遗失

}
