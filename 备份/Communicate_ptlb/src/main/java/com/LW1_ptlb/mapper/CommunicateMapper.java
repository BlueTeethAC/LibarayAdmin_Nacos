package com.LW1_ptlb.mapper;

import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.pojo.UserComments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
//@Mapper 注解：表示了这是一个 mybatis 的 mapper 类     是 Dao 层的
//@Repository用在持久层的接口上，这个注解是将接口的一个实现类交给spring管理，与 @Controller，@Service 等注解 作用一样
public interface CommunicateMapper {

    //书籍推荐部分

    //查询所有的书籍推荐
    List<BookCommunicate> getAllBookCommunicate();

    //按照书籍推荐id查询书记推荐信息
    BookCommunicate getBookCommunicateById(Integer bookCommunicateId);

    //按照推荐的书籍名查询书籍推荐（模糊查询）
    List<BookCommunicate> getBookCommunicateByBookName(String bookName);

    //按照用户名查询书籍推荐
    List<BookCommunicate> getBookCommunicateByUserName(String userName);

    //按照推荐的书籍名查询固定用户的书籍推荐（用户名固定，书籍名为模糊查询）
    List<BookCommunicate> getBookCommunicateByName(Map map);

    //新增书籍推荐
    Integer addBookCommunicate(Map map);

    //根据书籍推荐id修改书籍推荐
    Integer updateBookCommunicate(Map map);

    //根据书籍推荐id删除书籍推荐
    Integer deleteBookCommunicate(Integer bookCommunicateId);


    //用户评论部分

    //查询所有用户评论
    List<UserComments> getAllUserComments();

    //新增用户评论
    Integer addUserComments(Map map);

    //删除用户评论
    Integer deleteUserComments(Integer commentsId);

    //按照用户名查询评论记录
    List<UserComments> getUserCommentsByUserName(String userName);

    //按照用户名和日期查询评论记录（日期为模糊查询）
    List<UserComments> getUserCommentsByUserDate(Map map);

    //按照书籍推荐编号查询对应书籍的所有评论
    List<UserComments> getUserCommentsByBookId(Integer bookCommunicateId);
}
