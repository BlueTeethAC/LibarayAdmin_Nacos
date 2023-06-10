package com.LW1_ptlb.service.bookBorrowService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.feign.User_ptlb_feign;
import com.LW1_ptlb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

//新增借阅服务
@Service
public class AddBorrowService {

    //获得 User_ptlb_feign 接口
    @Autowired
    User_ptlb_feign user_ptlb_feign;

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    @ResponseBody
    public Integer addBorrow(String bookId,HttpSession session){

        //从session中获取存入的用户名
        String loginUser = (String) session.getAttribute("loginUser");
        System.out.println(loginUser);

        //获得当前用户对象
        User user = user_ptlb_feign.getUserFeign(loginUser);

        //获得当前用户 id
        Integer userId=user.getUserId();

        //执行新增借阅 方法
        Integer i = bookAdmin_pltb_feign.addBorrow(userId, bookId);

        return i;
        //0:借阅失败   1：借阅成功      2：借阅成功，但是更新具体书本状态失败     3：借阅成功，但是具体书本状态更新了多条数据，有问题      4：借阅异常
        //生成借阅书籍的记录，同时把借阅的书籍的状态改为 1（借出中）
    }

}
