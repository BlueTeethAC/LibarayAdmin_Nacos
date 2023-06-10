package com.LW1_ptlb.feign;

import com.LW1_ptlb.pojo.Book;
import com.LW1_ptlb.pojo.BookBorrowHistory;
import com.LW1_ptlb.pojo.BookCount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//图书存量管理模块接口调用
@FeignClient("BookAdminPtlb")//需要的服务名 BookAdminPtlb
@RestController//fegin 本质还是发送请求，所以需要
public interface BookAdmin_pltb_feign {

    //查询出所有 图书存量信息
    @RequestMapping("/LW1/BookAdmin/getAllBookAdmin")
    List<BookCount> getAllBookAdmin();
    //返回所有的 图书存量信息


    //按照书名查询到的书名信息（图书存量信息）（模糊查询）
    @RequestMapping("/LW1/BookAdmin/getBookAdmin2/{bookName}")
    List<BookCount> getBookAdmin2(@PathVariable("bookName") String bookName);
    //按照书名查询书名信息（图书存量）（模糊查询）


    //添加图书存量信息
    @RequestMapping("/LW1/BookAdmin/addBookAdmin/{bookName}/{bookPlace}/{bookPrice}/{maxNum}")
    Integer addBookAdmin(@PathVariable("bookName") String bookName,@PathVariable("bookPlace") String bookPlace,@PathVariable("bookPrice") float bookPrice,@PathVariable("maxNum") Integer maxNum);
    //0：书名插入失败   1：书名和书本都插入成功     2：书名插入成功，但是具体书本插入失败      3：书名重复


    //删除图书存量信息
    @RequestMapping("/LW1/BookAdmin/deleteBookAdmin/{bookName}")
    Integer deleteBookAdmin(@PathVariable("bookName") String bookName);
    //0：具体书本删除失败     1：具体书本 和 书名信息 都删除成功！    2：具体书本删除成功，但是 书名信息 删除失败！    3：表示没有查询书名


    //修改图书存量信息
    @RequestMapping("/LW1/BookAdmin/updateBookAdmin/{bookNameId}/{bookName}/{bookPlace}/{bookPrice}/{maxNum}")
    Integer updateBookAdmin(@PathVariable("bookNameId") Integer bookNameId,@PathVariable("bookName") String bookName,@PathVariable("bookPlace") String bookPlace,@PathVariable("bookPrice") float bookPrice,@PathVariable("maxNum") Integer maxNum);
    //0：更新失败   1：更新成功  非0和1：更新了多条数据，有问题


    //查询所有具体书本信息
    @RequestMapping("/LW1/BookAdmin/getAllBookInfo")
    List<Book> getAllBookInfo();
    //返回所有具体书本信息


    //按照书名查询具体书本信息
    @RequestMapping("/LW1/BookAdmin/getAllBookInfoByName/{bookName}")
    List<Book> getBookInfoByBookName(@PathVariable("bookName") String bookName);
    //返回根据具体署名查询到的书本信息


    //按照 书本具体id 查询具体书本信息
    @RequestMapping("/LW1/BookAdmin/getBookInfoById/{bookId}")
    List<Book> getBookInfoById(@PathVariable("bookId") String bookId);
    //返回根据 bookId 查询到的具体书本信息


    //新增书本具体信息
    @RequestMapping("/LW1/BookAdmin/addBook/{bookNameId}/{bookId}")
    Integer addBook(@PathVariable("bookNameId") Integer bookNameId,@PathVariable("bookId") String bookId);
    //返回 1：插入成功  0：插入失败  3：已有该书本信息(bookId 重复)


    //按照书名去查询书名id（辅助）
    @RequestMapping("/LW1/BookAdmin/getBookAdminIdByName/{bookName}")
    Integer getBookNameIdByBookName(@PathVariable("bookName") String bookName);
    //按照书名去查询查询到的书名id


    //按照具体书本id 删除 具体书本信息
    @RequestMapping("/LW1/BookAdmin/deleteBookById/{bookId}")
    Integer deleteBookById(@PathVariable("bookId") String bookId);
    //1：删除成功   0：删除失败


    //根据 bookId 具体书本id 修改 具体书本状态
    @RequestMapping("/LW1/BookAdmin/updateBookStatus/{bookId}/{borrowStatus}")
    Integer updateBookStatusById(@PathVariable("bookId") String bookId,@PathVariable("borrowStatus") Integer borrowStatus);
    //修改失败    1：修改成功   2：输入的状态代码 borrowStatus 不正确


    //根据书名查询所有当前可以借阅的书籍
    @RequestMapping("/LW1/BookAdmin/getCanBorrowByName/{bookName}")
    List<Book> getCanBorrowBookByName(@PathVariable("bookName") String bookName);
    //按照书名查询所有当前可以借阅的书籍



    //生成借阅书籍的记录，同时把借阅的书籍的状态改为 1（借出中）
    @RequestMapping("/LW1/BookAdmin/addBorrow/{userId}/{bookId}")
    Integer addBorrow(@PathVariable("userId") Integer userId,@PathVariable("bookId") String bookId);
    //0:借阅失败   1：借阅成功      2：借阅成功，但是更新具体书本状态失败     3：借阅成功，但是具体书本状态更新了多条数据，有问题      4：借阅异常
    //生成借阅书籍的记录，同时把借阅的书籍的状态改为 1（借出中）



    //按照用户名查询该用户的书籍借阅记录
    @RequestMapping("/LW1/BookAdmin/getHistoryByUserName/{userName}")
    List<BookBorrowHistory> myBorrowHistory(@PathVariable("userName") String userName);
    //按照用户名查询该用户的借阅记录


    //按照用户名查询该用户需要归还的书籍借阅记录
    @RequestMapping("/LW1/BookAdmin/getNeedReturnBook/{userName}")
    List<BookBorrowHistory> getNeedReturnBook(@PathVariable("userName") String userName);
    //按照用户名查询该用户需要归还的借阅记录


    //查询所有的借阅记录
    @RequestMapping("/LW1/BookAdmin/getAllHistory")
    List<BookBorrowHistory> getAllBorrow();
    //查询所有的借阅记录


    //归还书籍，修改书籍借阅记录，同时修改具体书本的状态
    @RequestMapping("/LW1/BookAdmin/returnBook/{returnStatus}/{borrowId}/{bookId}")
    Integer returnBook(@PathVariable("returnStatus") Integer returnStatus,@PathVariable("borrowId") Integer borrowId,@PathVariable("bookId") String bookId);
    //0：修改借阅记录状态失败     1：借阅记录状态 和 具体书本状态都修改成功      2：借阅记录状态修改异常    3：借阅记录状态修改成功，具体书本借阅状态修改失败      4：借阅记录状态修改成功，具体书本借阅状态修改异常


    //按照书本编号查询查询书籍借阅记录（模糊查询）
    @RequestMapping("/LW1/BookAdmin/getHistoryByBookId/{bookId}")
    List<BookBorrowHistory> getHistoryByBookId(@PathVariable("bookId") String bookId);
    //按照书本编号查询查询书籍借阅记录（模糊查询）


    //按照记录编号查询书籍借阅记录
    @RequestMapping("/LW1/BookAdmin/getHistoryByBorrowId/{borrowId}")
    List<BookBorrowHistory> getHistoryByBorrowId(@PathVariable("borrowId") Integer borrowId);
    //按照记录编号查询书籍借阅记录


    //按照书本编号查询用户书籍借阅记录（模糊查询）
    @RequestMapping("/LW1/BookAdmin/getMyHistoryByBookId/{bookId}/{userId}")
    List<BookBorrowHistory> getMyHistoryByBookId(@PathVariable("bookId") String bookId,@PathVariable("userId") Integer userId);
    //按照书本编号查询用户书籍借阅记录（模糊查询）


    //按照记录编号查询用户书籍借阅记录
    @RequestMapping("/LW1/BookAdmin/getMyHistoryByBorrowId/{borrowId}/{userId}")
    List<BookBorrowHistory> getMyHistoryByBorrowId(@PathVariable("borrowId") Integer borrowId,@PathVariable("userId") Integer userId);
    //按照记录编号查询用户书籍借阅记录


    //查询所有未归还的 借阅记录
    @RequestMapping("/LW1/BookAdmin/getAllNeedReturnHistory")
    List<BookBorrowHistory> getAllNeedReturnHistory();
    //查询所有未归还的 借阅记录

}
