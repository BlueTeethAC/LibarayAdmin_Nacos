package com.LW1_ptlb.service.SQLService;

import com.LW1_ptlb.mapper.CommunicateMapper;
import com.LW1_ptlb.pojo.BookCommunicate;
import com.LW1_ptlb.pojo.UserComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//数据库语句服务
@Service
public class SQLService implements CommunicateMapper {

    @Autowired
    CommunicateMapper communicateMapper;

    //书籍推荐部分

    //查询所有的书籍推荐
    @Override
    public List<BookCommunicate> getAllBookCommunicate() {
        return communicateMapper.getAllBookCommunicate();
    }

    //按照书籍推荐id查询书记推荐信息
    @Override
    public BookCommunicate getBookCommunicateById(Integer bookCommunicateId) {
        return communicateMapper.getBookCommunicateById(bookCommunicateId);
    }

    //按照推荐的书籍名查询书籍推荐（模糊查询）
    @Override
    public List<BookCommunicate> getBookCommunicateByBookName(String bookName) {
        return communicateMapper.getBookCommunicateByBookName(bookName);
    }

    //按照用户名查询书籍推荐
    @Override
    public List<BookCommunicate> getBookCommunicateByUserName(String userName) {
        return communicateMapper.getBookCommunicateByUserName(userName);
    }

    //按照推荐的书籍名查询固定用户的书籍推荐（用户名固定，书籍名为模糊查询）
    @Override
    public List<BookCommunicate> getBookCommunicateByName(Map map) {
        return communicateMapper.getBookCommunicateByName(map);
    }

    //新增书籍推荐
    @Override
    public Integer addBookCommunicate(Map map) {
        return communicateMapper.addBookCommunicate(map);
    }

    //根据书籍推荐id修改书籍推荐
    @Override
    public Integer updateBookCommunicate(Map map) {
        return communicateMapper.updateBookCommunicate(map);
    }

    //根据书籍推荐id删除书籍推荐
    @Override
    public Integer deleteBookCommunicate(Integer bookCommunicateId) {
        return communicateMapper.deleteBookCommunicate(bookCommunicateId);
    }


    //用户评论部分

    //查询所有用户评论
    @Override
    public List<UserComments> getAllUserComments() {
        return communicateMapper.getAllUserComments();
    }

    //新增用户评论
    @Override
    public Integer addUserComments(Map map) {
        return communicateMapper.addUserComments(map);
    }

    //删除用户评论
    @Override
    public Integer deleteUserComments(Integer commentsId) {
        return communicateMapper.deleteUserComments(commentsId);
    }

    //按照用户名查询评论记录
    @Override
    public List<UserComments> getUserCommentsByUserName(String userName) {
        return communicateMapper.getUserCommentsByUserName(userName);
    }

    //按照用户名和日期查询评论记录（日期为模糊查询）
    @Override
    public List<UserComments> getUserCommentsByUserDate(Map map) {
        return communicateMapper.getUserCommentsByUserDate(map);
    }

    //按照书籍推荐编号查询对应书籍的所有评论
    @Override
    public List<UserComments> getUserCommentsByBookId(Integer bookCommunicateId) {
        return communicateMapper.getUserCommentsByBookId(bookCommunicateId);
    }
}
