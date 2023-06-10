package com.LW1_ptlb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

//书本借阅记录实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowHistory {

    Integer borrowId;//记录编号
    String bookName;//具体书名
    Integer userId;//用户 id
    String bookId;//具体书本编号
    Date borrowDate;//借阅日期
    Date returnDate;//归还日期
    Integer returnStatus;//书籍状态

}
