package com.LW1_ptlb.controller.bookController;

import com.LW1_ptlb.service.BookService.UpdateBookStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//根据具体书本id 修改具体书本出借状态
@RestController
public class UpdateBookStatusController {

    //获得 修改具体书本状态服务
    @Autowired
    UpdateBookStatusService updateBookStatusService;

    //输入的参数 borrowStatus：0：未出借 1：出借 2：逾期未还 3：损坏/遗失
    @RequestMapping("/updateBookStatus/{bookId}/{borrowStatus}")
    public Integer updateBookStatus(@PathVariable("bookId") String bookId,@PathVariable("borrowStatus") Integer borrowStatus){

        //调用修改具体书本状态服务
        Integer i = updateBookStatusService.updateBook(bookId, borrowStatus);

        return i;//返回 0：修改失败    1：修改成功   2：输入的状态代码 borrowStatus 不正确
    }

}
