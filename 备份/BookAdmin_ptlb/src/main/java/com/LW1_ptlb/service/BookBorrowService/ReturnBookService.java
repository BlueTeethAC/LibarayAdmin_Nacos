package com.LW1_ptlb.service.BookBorrowService;

import com.LW1_ptlb.service.SQLService.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//还书（需要修改借阅记录状态，修改具体书本状态）服务
@Service
public class ReturnBookService {

    //获得 SQL 语句 服务
    @Autowired
    SQLService sqlService;

    public Integer returnBook(Integer returnStatus,Integer borrowId,String bookId){

        System.out.println(returnStatus);
        System.out.println(borrowId);
        System.out.println(bookId);

        if (returnStatus>3||returnStatus<0){
            return 4;//4：输入的借阅状态不对
        }else {

            Map<String,Integer> map = new HashMap();

            map.put("returnStatus",returnStatus);
            map.put("borrowId",borrowId);

            System.out.println("==============");
            System.out.println(map);
            System.out.println("==============");

            Integer i = sqlService.updateBorrowHistory(map);//修改 借阅记录的状态

            if (i.equals(1)){//i=1：表示修改借阅记录状态成功

                Integer borrowStatus=0;

                if (returnStatus.equals(2)){//如果借阅的状态为损坏
                    borrowStatus=3;//将书籍状态设置为 损坏
                }else {
                    borrowStatus=0;
                }

                Map<String,Object> map1 = new HashMap();
                map1.put("bookId",bookId);
                map1.put("borrowStatus",borrowStatus);

                Integer j = sqlService.updateBookStatus(map1);//修改具体书本借阅状态

                if (j.equals(1)){//修改具体书本借阅状态成功
                    return j;
                }else if (j.equals(0)){
                    return 3;//修改具体书本借阅状态失败
                }else {
                    return 4;//修改了多条具体书本的借阅状态，有异常
                }//0：修改借阅记录状态失败     1：借阅记录状态 和 具体书本状态都修改成功      2：借阅记录状态修改异常    3：借阅记录状态修改成功，具体书本借阅状态修改失败      4：借阅记录状态修改成功，具体书本借阅状态修改异常


            }else if (i.equals(0)){//修改借阅记录状态失败
                return i;
            }else {
                return 2;//修改了多条借阅记录，出现异常
            }
        }





    }

}
