package com.LW1_ptlb.controller.bookBorrowController.BorrowController;

import com.LW1_ptlb.service.bookBorrowService.ReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//归还书籍控制
@Controller
public class ReturnBookController {

    //归还书籍服务
    @Autowired
    ReturnBookService returnBookService;

    @RequestMapping("/main/returnBook")
    public String returnBook(@RequestParam("returnStatus") Integer returnStatus, @RequestParam("borrowId") Integer borrowId, @RequestParam("bookId") String bookId, Model model){

        //添加数据
        model.addAttribute("returnStatus",returnStatus);
        model.addAttribute("borrowId",borrowId);
        model.addAttribute("bookId",bookId);

        Integer i = returnBookService.returnBook(returnStatus, borrowId, bookId);
        //0：修改借阅记录状态失败     1：借阅记录状态 和 具体书本状态都修改成功      2：借阅记录状态修改异常    3：借阅记录状态修改成功，具体书本借阅状态修改失败      4：借阅记录状态修改成功，具体书本借阅状态修改异常

        System.err.println(i);

        if (i.equals(1)){//1：借阅记录状态 和 具体书本状态都修改成功

            System.out.println("借阅记录状态 和 具体书本状态都修改成功！");
            return "redirect:/main/goBorrowBookAdmin";

        }else if (i.equals(0)){//0：修改借阅记录状态失败

            System.err.println("修改借阅记录状态失败！");
            model.addAttribute("msg","修改借阅记录状态失败，请联系管理员");
            return "/borrowBook/returnBook";

        }else if (i.equals(2)){//2：借阅记录状态修改异常

            System.err.println("借阅记录状态修改异常！");
            model.addAttribute("msg","借阅记录状态修改异常，请联系管理员");
            return "/borrowBook/returnBook";

        }else if (i.equals(3)){//3：借阅记录状态修改成功，具体书本借阅状态修改失败

            System.err.println("借阅记录状态修改成功，具体书本借阅状态修改失败！");
            model.addAttribute("msg","借阅记录状态修改成功，具体书本借阅状态修改失败，请联系管理员");
            return "/borrowBook/returnBook";

        }else{//4：借阅记录状态修改成功，具体书本借阅状态修改异常

            System.err.println("借阅记录状态修改成功，具体书本借阅状态修改异常！");
            model.addAttribute("msg","借阅记录状态修改成功，具体书本借阅状态修改异常，请联系管理员");
            return "/borrowBook/returnBook";

        }
    }
}
