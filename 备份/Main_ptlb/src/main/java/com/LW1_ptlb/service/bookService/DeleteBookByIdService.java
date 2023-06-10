package com.LW1_ptlb.service.bookService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

//根据 具体书本id 删除 具体书本
@Service
public class DeleteBookByIdService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    //根据 具体书本id 删除 具体书本
    @ResponseBody
    public Integer deleteBookById(String bookId){
        Integer i = bookAdmin_pltb_feign.deleteBookById(bookId);
        //1：删除成功   0：删除失败

        return i;
    }

}
