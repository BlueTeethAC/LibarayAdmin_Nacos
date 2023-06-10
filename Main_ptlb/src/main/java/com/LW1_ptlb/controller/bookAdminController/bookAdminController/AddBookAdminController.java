package com.LW1_ptlb.controller.bookAdminController.bookAdminController;

import com.LW1_ptlb.service.bookAdminService.AddBookAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//添加图书存量信息控制
@Controller
public class AddBookAdminController {

    //获得 添加存量信息服务
    @Autowired
    AddBookAdminService addBookAdminService;

    //接收 addBookAdmin.html 表单传送来的数据
    @RequestMapping("/main/addBookAdmin")
    public String addBookAdmin(@RequestParam("bookName") String bookName, @RequestParam("bookPlace1") String bookPlace1, @RequestParam("bookPlace2") String bookPlace2, @RequestParam("bookPrice") float bookPrice, @RequestParam("maxNum") Integer maxNum, Model model){

        //给输入框存入数据，万一数值不对需要返回可以保留已经输入的数据
        model.addAttribute("bookName",bookName);
        model.addAttribute("bookPlace1",bookPlace1);
        model.addAttribute("bookPlace2",bookPlace2);
        model.addAttribute("bookPrice",bookPrice);
        model.addAttribute("maxNum",maxNum);

        //计算价格的小数位数
        String str = bookPrice + "";
        Integer num=str.length() - (str.indexOf(".") + 1);//计算小数位数
        System.out.println("小数位数："+num);


        //检查数据
        int i1= Integer.parseInt(bookPlace1);
        System.out.println(i1);
        int i2= Integer.parseInt(bookPlace2);
        System.out.println(i2);

        if (i1>0&&i1<11&&i2>0&&i2<9){//图书存放位置是否符合标准

            if (num<=2){//判断小数后是否为两位

                if (maxNum>=0&&maxNum<=10){//图书初始数量是否符合标准
                    Integer i = addBookAdminService.addBookAdmin(bookName, bookPlace1, bookPlace2, bookPrice, maxNum);
                    //0：书名插入失败   1：书名和书本都插入成功     2：书名插入成功，但是具体书本插入失败      3：书名重复

                    if (i.equals(1)){//插入成功！
                        System.out.println("书名和书本都插入成功！");
                        return "redirect:/main/goBookAdmin";
                    }else if (i.equals(0)){//书名插入失败！
                        System.err.println("书名插入失败！请联系管理员");
                        model.addAttribute("msg","书名插入失败！请联系管理员");
                        return "/bookAdmin/addBookAdmin.html";
                    }else if (i.equals(2)){//书名插入成功，但是具体书本插入失败！
                        System.err.println("书名插入成功，但是具体书本插入失败！");
                        model.addAttribute("msg","书名插入成功，但是具体书本插入失败！请联系管理员");
                        return "/bookAdmin/addBookAdmin.html";
                    }else{//书名重复
                        System.err.println("书名重复！");
                        model.addAttribute("msg","书名重复！");
                        return "/bookAdmin/addBookAdmin.html";
                    }

                }else {//图书初始数量不准确
                    System.err.println("图书初始数量超标！");
                    model.addAttribute("msg","图书初始数量超标！");
                    return "/bookAdmin/addBookAdmin.html";
                }

            }else {//如果小数位超过两位
                System.err.println("输入的单价格式有误！");
                model.addAttribute("msg","输入的单价格式有误！");
                return "/bookAdmin/addBookAdmin.html";
            }

        }else {//图书存放位置有问题
            System.err.println("图书存放位置不符合标准！");
            model.addAttribute("msg","图书存放位置不符合标准！");
            return "/bookAdmin/addBookAdmin.html";
        }


    }

}
