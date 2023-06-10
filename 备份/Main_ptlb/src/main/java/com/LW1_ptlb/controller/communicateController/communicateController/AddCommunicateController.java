package com.LW1_ptlb.controller.communicateController.communicateController;

import com.LW1_ptlb.service.communicateService.AddCommunicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//新增用户书籍推荐控制
@Controller
public class AddCommunicateController {

    //获得用户书籍推荐服务
    @Autowired
    AddCommunicateService addCommunicateService;

    //需要上传图片，必须为 POST
    @RequestMapping(value = "/main/addCommunicate", method = RequestMethod.POST)
    public String addCommunicate(@RequestParam("bookCommunicateName") String bookCommunicateName, @RequestParam("bookCommunicateSynopsis") String bookCommunicateSynopsis, @RequestParam("userName") String userName, MultipartFile uploadFile, Model model) {

        //上传图片部分
        //生成图片名称
        //获取当前项目路径
        String property = System.getProperty("user.dir");
        System.err.println(property);

        //代码表示规划上传文件的保存路径为项目运行目录下的uploadFile文件夹，并在文件夹中通过日期对所上传的文件归类保存。
        //String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
        String realPath = property + "/src/main/resources/static/bookCommunicatePicture/";

        System.out.println(realPath);

        //不需要日期为路径了
        File folder = new File(realPath);

        String filePath = "";

        if (folder.isDirectory()) {

            //生成文件名
            //首先获得日期
            Date date = new Date();

            //获得日期格式转换器，格式分别为为 yyyy_MM_DD
            SimpleDateFormat format = new SimpleDateFormat("YYYY_MM_dd");
            String nowDate = format.format(date);
            System.out.println(nowDate);


            //代码表示给上传的文件重命名，这是为了避免文件重名。第17行是文件保存操作
            folder.mkdirs();
            String oldName = uploadFile.getOriginalFilename();
            //文件名为 用户名_书名_日期
            String newName = userName+ '_' + bookCommunicateName+'_'+nowDate +'_'+ oldName.substring(oldName.lastIndexOf("."), oldName.length());
            //System.err.println(oldName.substring(oldName.lastIndexOf("."), oldName.length()));//文件后缀
            //String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());

            //输出新的文件名
            System.out.println(newName);

            //设置图片文件名
            String bookCommunicatePicture=newName;




            //进行添加实际推荐信息的操作
            Integer i = addCommunicateService.addCommunicate(bookCommunicateName, bookCommunicateSynopsis, bookCommunicatePicture, userName);
            if (i.equals(1)){//新增成功


                //执行文件上传
                try {

                    //生成上传文件的访问路径，并将访问路径返回
                    uploadFile.transferTo(new File(folder, newName));
                    filePath = realPath + newName;

                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("上传失败");
                    model.addAttribute("msg","上传失败，请联系管理员！");
                    model.addAttribute("bookCommunicateName",bookCommunicateName);
                    model.addAttribute("bookCommunicateSynopsis",bookCommunicateSynopsis);
                    return "/communicate/addCommunicate";
                }

                System.out.println(filePath);



                return "redirect:/main/goMyCommunicate";
            }else {//新增失败

                System.err.println("新增失败1");
                model.addAttribute("msg","新增失败，请联系管理员！");
                model.addAttribute("bookCommunicateName",bookCommunicateName);
                model.addAttribute("bookCommunicateSynopsis",bookCommunicateSynopsis);

                return "/communicate/addCommunicate";
            }

        }else {//新增失败

            System.err.println("新增失败2");
            model.addAttribute("msg","新增失败，请联系管理员！");
            model.addAttribute("bookCommunicateName",bookCommunicateName);
            model.addAttribute("bookCommunicateSynopsis",bookCommunicateSynopsis);

            return "/communicate/addCommunicate";
        }

    }

}
