package com.LW1_ptlb.controller.bookBorrowController.goController;

import com.LW1_ptlb.service.bookBorrowService.GoBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.Map;

//跳转到 确认借阅书籍界面，同时展示借阅信息
@Controller
public class GoAgainBorrowByIdController {

    //获得 跳转确认借阅书籍界面对应的服务
    @Autowired
    GoBorrowService goBorrowService;

    @RequestMapping("/main/goAgainBorrowById/{bookName}/{bookId}")
    public String goBorrow(@PathVariable("bookName") String bookName, @PathVariable("bookId") String bookId, Model model){

        Map<String, Object> map = goBorrowService.goBorrow(bookName, bookId);

        //获得生成的 map 中的数据
        String nowBookName = (String) map.get("bookName");
        String nowBookId = (String) map.get("bookId");
        Date borrowDate = (Date) map.get("borrowDate");
        Date returnDate = (Date) map.get("returnDate");

        System.out.println(map);

        model.addAttribute("bookName",bookName);
        model.addAttribute("bookId",bookId);
        model.addAttribute("borrowDate",borrowDate);
        model.addAttribute("returnDate",returnDate);

        return "/borrowBook/againBorrowById";
    }
}
