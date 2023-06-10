package com.LW1_ptlb.service.BookService;

import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//具体书本出借
@Service
public class BookBorrowService {

    //获得 SQL 语句 服务
    @Autowired
    SQLService sqlService;



}
