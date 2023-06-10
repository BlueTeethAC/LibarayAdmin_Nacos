package com.LW1_ptlb.service.bookService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

//根据 具体书本id 修改书本状态
@Service
public class UpdateBookByIdService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    @ResponseBody
    public Integer updateBookById(String bookId,Integer bookStatus){

        Integer i = bookAdmin_pltb_feign.updateBookStatusById(bookId, bookStatus);
        //根据输入的  bookId 具体书名代码，borrowStatus 具体书本出借状态 修改 具体书本的 出借状态

        return i;//修改失败    1：修改成功   2：输入的状态代码 borrowStatus 不正确
    }
}
