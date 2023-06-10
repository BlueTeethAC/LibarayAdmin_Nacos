package com.LW1_ptlb.mapper;

import com.LW1_ptlb.pojo.Book;
import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.pojo.BookCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
//@Mapper 注解：表示了这是一个 mybatis 的 mapper 类     是 Dao 层的
//@Repository用在持久层的接口上，这个注解是将接口的一个实现类交给spring管理，与 @Controller，@Service 等注解 作用一样
public interface BookAdminMapper {

    //图书存量信息

    //查询所有 图书存量的信息
    List<BookCount> selectBookAdmin();

    //按照书名去查询书名（查重用的）
    String selectBookNameByBookName(String bookName);

    //按照书名去查询书名id（辅助）
    Integer selectBookNameIdByBookName(String bookName);

    //查询具体某个图书存量信息
    BookCount selectBookAdminByBookName(String bookName);

    //查询具体某个图书存量信息（模糊查询）
    List<BookCount> selectBookAdminByBookName2(String bookName);

    //添加新的 图书存量信息
    Integer addBookAdmin(Map map);

    //修改图书存量信息（按照用户 id，插入的 bookCount 需要 id 不变）
    Integer updateBookAdmin(Map map);

    //删除图书存量信息（用的时候记得把 具体书本 和 图书借阅状态 状态都改为 0）
    Integer deleteBookAdmin(String bookName);//删除图书存量信息会把 book_count，book_borrowing_status 中对应的信息的状态 status 都改为 0



    //书本信息

    //查询所有书本信息
    List<Book> selectAllBook();

    //查询当前可以借阅的书籍
    List<Book> selectCanBorrowBook();

    //按照书名查询当前可以借阅的书籍
    List<Book> selectCanBorrowBookByName(String bookName);

    //按照 书名查询书本信息
    List<Book> selectAllBookByBookName(String bookName);

    //按照书本id去查询书本id（查重用的）
    String selectBookIdByBookId(String bookId);

    //按照 书本id 查询书本信息
    List<Book> selectBookByBookId(String BookId);

    //添加 新的书本
    Integer addBookInfo(Map map);

    //修改 具体书本 的状态
    Integer updateBookStatus(Map map);//borrowStatus：0：未出借 1：出借 2：逾期未还 3：损坏/遗失

    //删除 按照书名删除一批书本（把书本状态改为 0，只有在删除 图书存量信息的时候才去调用）
    Integer deleteBookByBookNameId(Integer bookNameId);

    //删除 按照鼠标呢删除具体一本书本（把书本状态改为 0）
    Integer deleteBookByBookId(String bookId);



    //书本借阅

    //查询所有书本借阅记录
    List<BookBorrowHistory> selectAllHistory();

    //按照用户名 查询该用户的 借阅记录
    List<BookBorrowHistory> selectHistoryByUserName(String userName);

    //按照用户名 查询该用户未归还的 借阅记录
    List<BookBorrowHistory> selectNeedReturnHistory(String userName);

    //查询所有未归还的 借阅记录
    List<BookBorrowHistory> selectAllNeedReturnHistory();

    //用户借阅书籍（生成一条借阅记录）
    Integer addBorrowHistory(Map map);

    //用户归还书籍（按照借阅的记录编号 修改一条借阅记录）
    Integer updateBorrowHistory(Map map);

    //按照书本编号查询书籍借阅记录（模糊查询）
    List<BookBorrowHistory> selectHistoryByBookId(String bookId);

    //按照书本编号查询用户书籍借阅记录（模糊查询）
    List<BookBorrowHistory> selectMyHistoryByBookId(Map map);

    //按照记录编号查询书籍借阅记录
    List<BookBorrowHistory> selectHistoryByBorrowId(Integer borrowId);

    //按照记录编号查询用户书籍借阅记录
    List<BookBorrowHistory> selectMyHistoryByBorrowId(Map map);

    //按照（记录编号）删除 借阅记录
    Integer deleteBorrowHistory(Integer borrowId);

}
