package com.LW1_ptlb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration //@Configuration 添加了这个注解后，它会变成一个配置类  DispatcherServlet
public class MyMvcConfig implements WebMvcConfigurer {

    //@Override
    //添加视图控制
    public void addViewControllers(ViewControllerRegistry registry) {
        //添加视图控制：添加视图跳转
        //registry.addViewController("接受的指令").setViewName("跳转到的页面");
    }

    //自定义的国际化组件就装配到 bean 里了，装配进 SpringBoot 生效了
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

    @Override
    //添加自定义的拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns("/**")：添加拦截的文件路径
        //excludePathPatterns("/index.html","/","/user/login","/css/*","/js/**","/image/**")：设置不用拦截的文件路径
        //registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.html","/","/user/login","/css/*","/js/**","/image/**","/user/**","/top_admin/**","/admin/**");
        //excludePathPatterns：输入的是请求的路径，并不是文件路径
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.html","/main/goRegister","/main/registered","/","/main/login","","/css/*","/js/**","/image/**");
    }



    //添加资源映射
    //这样子 communicateRead 访问 img 文件的时候，只要路径是 /bookCommunicatePicture/开头的，会直接跳转到绝对路径 D:\Lesson_SpringBoot\Again_PTLB\PTLB\Main_ptlb\src\main\resources\static\bookCommunicatePicture\ 下的资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //获取当前项目路径
        String property = System.getProperty("user.dir");
        System.err.println(property);

        //代码表示规划上传文件的保存路径为项目运行目录下的uploadFile文件夹，并在文件夹中通过日期对所上传的文件归类保存。
        //String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
        String realPath = property + "\\src\\main\\resources\\static\\bookCommunicatePicture\\";
        //"file:"+realPath 就是 该项目路径下的 \src\main\resources\static\bookCommunicatePicture\
        registry.addResourceHandler("/bookCommunicatePicture/**").addResourceLocations("file:"+realPath);
        //registry.addResourceHandler("/bookCommunicatePicture/**").addResourceLocations("file:D:\\Lesson_SpringBoot\\Again_PTLB\\PTLB\\Main_ptlb\\src\\main\\resources\\static\\bookCommunicatePicture\\");
    }
}
