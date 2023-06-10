package com.LW1_ptlb.feign;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.pojo.UserComments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//用户模块接口调用
@FeignClient("CommunicatePtlb")//需要的服务名 User_ptlb
@RestController//fegin 本质还是发送请求，所以需要
public interface Communicate_ptlb_feign {

    //书籍推荐部分

    //查询所有的书籍推荐
    @RequestMapping("/LW1/Communicate/getAllCommunicate")
    List<BookCommunicate> getAllCommunicate();
    //查询所有书籍推荐

    //按照书籍推荐id查询书记推荐信息
    @RequestMapping("/LW1/Communicate/getCommunicateById/{bookCommunicateId}")
    BookCommunicate getCommunicateById(@PathVariable("bookCommunicateId") Integer bookCommunicateId);
    //按照书籍推荐id查询书记推荐信息

    //按照推荐的书籍名查询书籍推荐（模糊查询）
    @RequestMapping("/LW1/Communicate/getCommunicateByBookName/{bookName}")
    List<BookCommunicate> getCommunicateByBookName(@PathVariable("bookName") String bookName);
    //按照推荐的书籍名查询书籍推荐（模糊查询）

    //按照用户名查询书籍推荐
    @RequestMapping("/LW1/Communicate/getCommunicateByUserName/{userName}")
    List<BookCommunicate> getCommunicateByUserName(@PathVariable("userName") String userName);
    //按照用户名查询书籍推荐

    //按照推荐的书籍名查询固定用户的书籍推荐（用户名固定，书籍名为模糊查询）
    @RequestMapping("/LW1/Communicate/getCommunicateByName/{bookCommunicateName}/{userName}")
    List<BookCommunicate> getCommunicateByName(@PathVariable("bookCommunicateName") String bookCommunicateName,@PathVariable("userName") String userName);
    //按照推荐的书籍名查询固定用户的书籍推荐（用户名固定，书籍名为模糊查询）

    //新增书籍推荐
    @RequestMapping("/LW1/Communicate/addCommunicate/{bookCommunicateName}/{bookCommunicateSynopsis}/{bookCommunicatePicture}/{userName}")
    Integer addCommunicate(@PathVariable("bookCommunicateName") String bookCommunicateName,@PathVariable("bookCommunicateSynopsis") String bookCommunicateSynopsis,@PathVariable("bookCommunicatePicture") String bookCommunicatePicture,@PathVariable("userName") String userName);
    //0：新增失败   1：新增成功

    //根据书籍推荐id修改书籍推荐
    @RequestMapping("/LW1/Communicate/updateCommunicate/{bookCommunicateName}/{bookCommunicateSynopsis}/{bookCommunicateId}")
    Integer updateCommunicate(@PathVariable("bookCommunicateName") String bookCommunicateName,@PathVariable("bookCommunicateSynopsis") String bookCommunicateSynopsis,@PathVariable("bookCommunicateId") Integer bookCommunicateId);
    //0：更新失败       1：更新成功      其他的数字：更新异常

    //根据书籍推荐id删除书籍推荐
    @RequestMapping("/LW1/Communicate/deleteCommunicate/{bookCommunicateId}")
    Integer deleteCommunicate(@PathVariable("bookCommunicateId") Integer bookCommunicateId);
    //0：删除失败       1：删除成功      其他的数字：删除异常




    //用户评论部分

    //查询所有用户评论
    @RequestMapping("/LW1/Communicate/getAllComments")
    List<UserComments> getAllComments();
    //查询所有用户评论

    //新增用户评论
    @RequestMapping("/LW1/Communicate/addUserComments/{userName}/{userComments}/{bookCommunicateId}")
    Integer addUserComments(@PathVariable("userName") String userName,@PathVariable("userComments") String userComments,@PathVariable("bookCommunicateId") Integer bookCommunicateId);
    //0：新增失败   1：新增成功

    //删除用户评论
    @RequestMapping("/LW1/Communicate/deleteUserComments/{commentsId}")
    Integer deleteUserComments(@PathVariable("commentsId") Integer commentsId);
    //0：删除失败       1：删除成功      其他的数字：删除异常

    //按照用户名查询评论记录
    @RequestMapping("/LW1/Communicate/getUserCommentsByUserName/{userName}")
    List<UserComments> getUserCommentsByUserName(@PathVariable("userName") String userName);
    //按照用户名查询评论记录

    //按照用户名和日期查询评论记录（日期为模糊查询）
    @RequestMapping("/LW1/Communicate/getUserCommentsByUserDate/{userName}/{date}")
    List<UserComments> getUserCommentsByUserDate(@PathVariable("userName") String userName,@PathVariable("date") String date);
    //按照用户名和日期查询评论记录（日期为模糊查询）

    //按照书籍推荐编号查询对应书籍的所有评论
    @RequestMapping("/LW1/Communicate/getUserCommentsByBookId/{bookCommunicateId}")
    List<UserComments> getUserCommentsByBookId(@PathVariable("bookCommunicateId") Integer bookCommunicateId);
    //按照书籍推荐编号查询对应书籍的所有评论

}
