package com.LW1_ptlb.controller.bookBorrowController.BorrowController;

import com.LW1_ptlb.service.bookBorrowService.AddBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;

//借阅书籍 控制
@Controller
public class AddBorrowController {

    //获得 借阅书籍 服务
    @Autowired
    AddBorrowService addBorrowService;

    @RequestMapping("/main/addBorrow")
    public String addBorrow(@RequestParam("bookName") String bookName,@RequestParam("bookId") String bookId,@RequestParam("borrowDate") Date borrowDate,@RequestParam("returnDate") Date returnDate, HttpSession session, Model model){

        //生成借阅书籍的记录，同时把借阅的书籍的状态改为 1（借出中）
        Integer i = addBorrowService.addBorrow(bookId, session);
        //0:借阅失败   1：借阅成功      2：借阅成功，但是更新具体书本状态失败     3：借阅成功，但是具体书本状态更新了多条数据，有问题      4：借阅异常

        if (i.equals(1)){//1。借阅成功！
            System.out.println("借阅成功！");
            return "redirect:/main/goBorrowBook";
        }else if (i.equals(0)){////0:借阅失败
            System.err.println("借阅失败，请联系管理员！");
            model.addAttribute("msg","借阅失败，请联系管理员！");
            return "/borrowBook/againBorrowById";
        }else if (i.equals(2)){//2：借阅成功，但是更新具体书本状态失败
            System.err.println("借阅成功，但是更新具体书本状态失败，请联系管理员！");
            model.addAttribute("msg","借阅成功，但是更新具体书本状态失败，请联系管理员！");
            return "/borrowBook/againBorrowById";
        }else if (i.equals(3)){//3：借阅成功，但是具体书本状态更新了多条数据，有问题
            System.err.println("借阅成功，但是具体书本状态更新了多条数据，有问题，请联系管理员！");
            model.addAttribute("msg","借阅成功，但是具体书本状态更新了多条数据，有问题，请联系管理员！");
            return "/borrowBook/againBorrowById";
        }else{//4：借阅异常
            System.err.println("借阅异常，请联系管理员！");
            model.addAttribute("msg","借阅异常，请联系管理员！");
            return "/borrowBook/againBorrowById";
        }

    }

}
