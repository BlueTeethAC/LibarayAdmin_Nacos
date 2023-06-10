package com.LW1_ptlb.controller.bookBorrowController.BorrowController;

import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.service.bookBorrowService.GetAllNeedReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//查询所有未归还的 借阅记录 控制
@Controller
public class GetAllNeedReturnHistoryController {

    //获得 查询所有未归还的 借阅记录 服务
    @Autowired
    GetAllNeedReturnHistoryService getAllNeedReturnHistoryService;

    @RequestMapping("/main/getAllNeedReturnHistory")
    public String getAllNeedReturnHistory(Model model){

        List<BookBorrowHistory> allNeedReturnHistory = getAllNeedReturnHistoryService.getAllNeedReturnHistory();

        model.addAttribute("allBorrow",allNeedReturnHistory);

        return "/borrowBook/borrowBookAdmin";
    }
}
