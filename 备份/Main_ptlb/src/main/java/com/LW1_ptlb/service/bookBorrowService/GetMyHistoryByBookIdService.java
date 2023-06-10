package com.LW1_ptlb.service.bookBorrowService;

import com.LW1_ptlb.feign.BookAdmin_pltb_feign;
import com.LW1_ptlb.feign.User_ptlb_feign;
import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//按照书本编号查询用户书籍借阅记录（模糊查询）
@Service
public class GetMyHistoryByBookIdService {

    //获得 BookAdmin_pltb_feign 接口
    @Autowired
    BookAdmin_pltb_feign bookAdmin_pltb_feign;

    //获得 User_ptlb_feign 接口
    @Autowired
    User_ptlb_feign user_ptlb_feign;

    @ResponseBody
    public List<BookBorrowHistory> getMyHistoryByBookId( String bookId,String userName){

        //获得用户对象
        User user = user_ptlb_feign.getUserFeign(userName);

        //获得 userId
        Integer userId=user.getUserId();

        List<BookBorrowHistory> myHistoryByBorrowId = bookAdmin_pltb_feign.getMyHistoryByBookId(bookId, userId);
        return myHistoryByBorrowId;
    }
}
