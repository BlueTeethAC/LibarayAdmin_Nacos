package com.LW1_ptlb.service.SQLService;

import com.LW1_ptlb.mapper.BookAdminMapper;
import com.LW1_ptlb.pojo.Book;
import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.pojo.BookCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SQLService implements BookAdminMapper {

    //获得 bookAdminMapper
    @Autowired
    BookAdminMapper bookAdminMapper;

    //图书存量信息

    @Override
    //查询所有 图书存量的信息
    public List<BookCount> selectBookAdmin() {
        return bookAdminMapper.selectBookAdmin();
    }

    @Override
    //按照图书名查询图书名（查重用的）
    public String selectBookNameByBookName(String bookName) {
        return bookAdminMapper.selectBookNameByBookName(bookName);
    }

    @Override
    //按照书名去查询书名id（辅助）
    public Integer selectBookNameIdByBookName(String bookName) {
        return bookAdminMapper.selectBookNameIdByBookName(bookName);
    }

    @Override
    //查询具体某个图书存量信息
    public BookCount selectBookAdminByBookName(String bookName) {
        return bookAdminMapper.selectBookAdminByBookName(bookName);
    }

    @Override
    //查询具体某个图书存量信息（模糊查询）
    public List<BookCount> selectBookAdminByBookName2(String bookName) {
        return bookAdminMapper.selectBookAdminByBookName2(bookName);
    }

    @Override
    //添加新的 图书存量信息
    public Integer addBookAdmin(Map map) {
        return bookAdminMapper.addBookAdmin(map);
    }

    @Override
    //修改图书存量信息（按照用户 id，插入的 bookCount 需要 id 不变）
    public Integer updateBookAdmin(Map map) {
        return bookAdminMapper.updateBookAdmin(map);
    }

    @Override
    //删除图书存量信息（用的时候记得把 具体书本 和 图书借阅状态 状态都改为 0）
    //删除图书存量信息 记得把 book_count，book_borrowing_status 中对应的信息的状态 status 都改为 0
    public Integer deleteBookAdmin(String bookName) {
        return bookAdminMapper.deleteBookAdmin(bookName);
    }


    //书本信息

    @Override
    //查询所有书本信息
    public List<Book> selectAllBook() {
        return bookAdminMapper.selectAllBook();
    }

    @Override
    //查询当前可以借阅的书籍
    public List<Book> selectCanBorrowBook() {
        return bookAdminMapper.selectCanBorrowBook();
    }

    @Override
    //按照书名查询当前可以借阅的书籍
    public List<Book> selectCanBorrowBookByName(String bookName) {
        return bookAdminMapper.selectCanBorrowBookByName(bookName);
    }

    @Override
    //按照 书名查询书本信息
    public List<Book> selectAllBookByBookName(String bookName) {
        return bookAdminMapper.selectAllBookByBookName(bookName);
    }

    @Override
    //按照书本id去查询书本id（查重用的）
    public String selectBookIdByBookId(String bookId) {
        return bookAdminMapper.selectBookIdByBookId(bookId);
    }

    @Override
    //按照 书本id 查询书本信息
    public List<Book> selectBookByBookId(String bookId) {
        return bookAdminMapper.selectBookByBookId(bookId);
    }

    @Override
    //添加 新的书本
    public Integer addBookInfo(Map map) {
        return bookAdminMapper.addBookInfo(map);
    }

    @Override
    //修改 具体书本 的状态
    //borrowStatus：0：未出借 1：出借 2：逾期未还 3：损坏/遗失
    public Integer updateBookStatus(Map map) {
        return bookAdminMapper.updateBookStatus(map);
    }

    @Override
    //删除 按照书名删除一批书本（把书本状态改为 0，只有在删除 图书存量信息的时候才去调用）
    public Integer deleteBookByBookNameId(Integer bookNameId) {
        return bookAdminMapper.deleteBookByBookNameId(bookNameId);
    }

    @Override
    //删除 按照鼠标呢删除具体一本书本（把书本状态改为 0）
    public Integer deleteBookByBookId(String bookId) {
        return bookAdminMapper.deleteBookByBookId(bookId);
    }


    //书本借阅

    @Override
    //查询所有书本借阅记录
    public List<BookBorrowHistory> selectAllHistory() {
        return bookAdminMapper.selectAllHistory();
    }

    @Override
    //按照用户名 查询该用户的 借阅记录
    public List<BookBorrowHistory> selectHistoryByUserName(String userName) {
        return bookAdminMapper.selectHistoryByUserName(userName);
    }

    @Override
    //按照用户名 查询该用户未归还的 借阅记录
    public List<BookBorrowHistory> selectNeedReturnHistory(String userName) {
        return bookAdminMapper.selectNeedReturnHistory(userName);
    }

    @Override
    //查询所有未归还的 借阅记录
    public List<BookBorrowHistory> selectAllNeedReturnHistory() {
        return bookAdminMapper.selectAllNeedReturnHistory();
    }

    @Override
    //用户借阅书籍（生成一条借阅记录）
    public Integer addBorrowHistory(Map map) {
        return bookAdminMapper.addBorrowHistory(map);
    }

    @Override
    //按照书本编号查询查询书籍借阅记录
    public List<BookBorrowHistory> selectHistoryByBookId(String bookId) {
        return bookAdminMapper.selectHistoryByBookId(bookId);
    }

    @Override
    //按照记录编号查询书籍借阅记录
    public List<BookBorrowHistory> selectHistoryByBorrowId(Integer borrowId) {
        return bookAdminMapper.selectHistoryByBorrowId(borrowId);
    }

    @Override
    //按照书本编号查询用户书籍借阅记录（模糊查询）
    public List<BookBorrowHistory> selectMyHistoryByBookId(Map map) {
        return bookAdminMapper.selectMyHistoryByBookId(map);
    }

    @Override
    //按照记录编号查询用户书籍借阅记录
    public List<BookBorrowHistory> selectMyHistoryByBorrowId(Map map) {
        return bookAdminMapper.selectMyHistoryByBorrowId(map);
    }

    @Override
    //用户归还书籍（按照借阅的记录编号 修改一条借阅记录）
    public Integer updateBorrowHistory(Map map) {
        return bookAdminMapper.updateBorrowHistory(map);
    }

    @Override
    //按照（记录编号）删除 借阅记录
    public Integer deleteBorrowHistory(Integer borrowId) {
        return bookAdminMapper.deleteBorrowHistory(borrowId);
    }
}
