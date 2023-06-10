package com.LW1_ptlb.controller.userController;

import com.LW1_ptlb.service.userService.DeleteUserByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeleteUserByNameController {

    @Autowired
    DeleteUserByNameService deleteUserByNameService;

    @RequestMapping("/main/deleteUserByName/{username}")
    public String deleteUserByName(@PathVariable("username") String username){

        Integer integer = deleteUserByNameService.deleteUser(username);//进行删除
        //删除成功则返回 1，删除失败返回 0

        if (integer.equals(1)){
            System.out.println("删除成功!");
            return "redirect:/main/goUserAdmin";
        }else {
            System.err.println("删除失败！");
            return "redirect:/main/goUserAdmin";
        }

    }

}
