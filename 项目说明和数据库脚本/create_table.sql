USE test_ptlb

/*用户表*/
CREATE TABLE `user`(
	user_id INT(14) PRIMARY KEY, /*用户id*/  
	username VARCHAR(10) UNIQUE NOT NULL, /*用户名*/
	pwd VARCHAR(20) NOT NULL, /*密码*/
	grade INT(2) DEFAULT(0) NOT NULL, /*权限等级，默认为0最低级*/
	`status` INT(2) DEFAULT(1) NOT NULL /*是否生效*/
);


/*图书存量表*/
CREATE TABLE `book_count`(
	book_name_id INT(6) PRIMARY KEY  AUTO_INCREMENT,/*书名id，并且从 1 开始自增*/
	book_name VARCHAR(50) UNIQUE NOT NULL,/*书名*/
	book_place CHAR(10) NOT NULL,/*图书存放位置 书柜号+L+行号（例：AL1）*/
	book_price FLOAT(6) NOT NULL,/*书本单价*/
	max_num INT(4) NOT NULL, /*书本最大数量*/
	/*now_num int(4) not null,*/ /*图书馆欸该书本当前数量*/
	`status` INT(2) DEFAULT(1) NOT NULL, /*是否生效*/
	CONSTRAINT `max_num1` CHECK((max_num>=0))
)AUTO_INCREMENT=1;/*设置主键自增初始值为 1 */



/*图书借阅状态表*/
-- CREATE TABLE `book_borrowing_status`(
--	book_id CHAR(14) PRIMARY KEY,/*图书编号  书名 id + A + 同书名第几本 （例：001A001）*/
--	borrow_status INT(2) NOT NULL,/*0：未出借 1：出借 2：逾期未还 3：损坏/遗失*/
--	`status` INT(2) DEFAULT(1) NOT NULL/*是否生效*/
-- );


/*图书关系表*/
CREATE TABLE `book_book_id`(
	context_id INT(2) PRIMARY KEY AUTO_INCREMENT,/*关系id 自增*/
	book_name_id INT(6)  NOT NULL,/*书名id*/
	book_id CHAR(14) NOT NULL,/*图书编号  书名 id + A + 同书名第几本 （例：001A001）*/
	borrow_status INT(2) DEFAULT(0) NOT NULL,/*0：未出借 1：出借 2：逾期未还 3：损坏/遗失*/
	`status` INT(2) DEFAULT(1) NOT NULL, /*是否生效*/
	CONSTRAINT `book_name_id1` FOREIGN KEY (book_name_id) REFERENCES `book_count`(book_name_id),/*book_name_id 的外码*/
	-- CONSTRAINT `book_id1` FOREIGN KEY (book_id) REFERENCES `book_borrowing_status`(book_id)/*book_id 的外码*/
)AUTO_INCREMENT=1;


/*借阅记录表*/
CREATE TABLE `borrow_history`(
	borrow_id INT(16) PRIMARY KEY AUTO_INCREMENT,/*记录编号*/
	user_id INT(14) NOT NULL, /*用户id（外码）*/
	book_id CHAR(14) NOT NULL,/*图书编号 外码*/
	borrow_date DATE NOT NULL,/*借阅日期*/
	return_date DATE NOT NULL,/*归还日期*/
	return_status INT(2) DEFAULT(0) NOT NULL,/*0：未归还	1：已归还	2：损坏/遗失	3：已经补偿*/
	`status` INT(2) DEFAULT(1) NOT NULL, /*是否生效*/
	
	CONSTRAINT `user_id_1` FOREIGN KEY(user_id) REFERENCES `user`(user_id), /*user_id 的外码*/
	CONSTRAINT `book_id_1` FOREIGN KEY(book_id) REFERENCES `book_book_id`(book_id)/*book_id 的外码*/
)






/*书籍推荐表*/
CREATE TABLE `book_communicate`(
	book_communicate_id INT(6) PRIMARY KEY AUTO_INCREMENT,/*书籍推荐编号*/
	book_communicate_name VARCHAR(50) NOT NULL,/*推荐书籍名*/
	book_communicate_synopsis VARCHAR(400),/*书籍简介，最大200字*/
	book_communicate_picture VARCHAR(200),/*书籍封面链接*/
	username VARCHAR(10),/*用户名外码*/
	`status` INT(2) DEFAULT(1) NOT NULL, /*是否生效*/
	CONSTRAINT `username_2` FOREIGN KEY(username) REFERENCES `user`(username)/*username 的外码*/
);

/*用户评论*/
CREATE TABLE `user_comments`(
	comments_id INT(3) PRIMARY KEY AUTO_INCREMENT,/*书籍评论编号*/
	username VARCHAR(10),/*用户名外码*/
	user_comments VARCHAR(200) NOT NULL,/*用户评论，最大100字*/
	comments_date DATE NOT NULL,/*评论日期*/
	book_communicate_id INT(6),/*书籍推荐编号*/
	`status` INT(2) DEFAULT(1) NOT NULL, /*是否生效*/
	CONSTRAINT `username_1` FOREIGN KEY(username) REFERENCES `user`(username),/*username 的外码*/
	CONSTRAINT `book_communicate_id_1` FOREIGN KEY(book_communicate_id) REFERENCES `book_communicate`(book_communicate_id)/*书籍推荐编号*/
);

/*评论联系表*/
-- CREATE TABLE `comments_context`(
--	context_id INT(3) PRIMARY KEY AUTO_INCREMENT,/*联系编号*/
--	book_communicate_id INT(6),/*书籍推荐编号*/
--	comments_id INT(3),/*评论编号*/
--	`status` INT(2) DEFAULT(1) NOT NULL, /*是否生效*/
--	CONSTRAINT `book_communicate_id_1` FOREIGN KEY(book_communicate_id) REFERENCES `book_communicate`(book_communicate_id),/*书籍推荐编号*/
--	CONSTRAINT `comments_id_1` FOREIGN KEY(comments_id) REFERENCES `user_comments`(comments_id)/*书籍评论编号*/
-- );




/*=====================创建视图=======================*/

/*用户表的视图*/
CREATE VIEW `user_vw`(userid,username,pwd,grade) AS 
SELECT user_id,username,pwd,grade FROM `user` WHERE `status`=1;



/*图书存量表的视图*/
CREATE VIEW `book_count_vw`(book_name_id,book_name,book_place,book_price,max_num,now_num) AS (

	SELECT book_name_id,/*书名id*/
		book_name,/*书名*/
		book_place,/*图书存放位置 书柜号+L+行号（例：AL1）*/
		book_price,/*书本单价*/
		max_num,/*书本最大数量*/
		(SELECT COUNT(*) FROM book_book_id WHERE book_name_id = book_count.book_name_id AND borrow_status=0) AS now_num /*现在图书馆内有多少该书籍，出借和损坏的不算*/
	FROM book_count WHERE `status`=1

);


/*图书借阅状态视图*/
-- CREATE VIEW `book_borrowing_status_vw`(book_id,borrow_status) AS (
--	
--	SELECT book_id,/*图书编号  书名 id + A + 同书名第几本 （例：001A001）*/
--		borrow_status /*是否生效*/
--	FROM book_borrowing_status WHERE `status`=1
--
-- );

/*图书关系视图*/
-- CREATE VIEW `book_book_id_vw`(context_id,book_name_id,book_id) AS (
	
--	SELECT context_id,/*关系id 自增*/
--		book_name_id,/*书名id*/
--		book_id /*图书编号  书名 id + A + 同书名第几本 （例：001A001）*/
--		borrow_status /*图书当前状态：0：未出借 1：出借 2：逾期未还 3：损坏/遗失*/
--	FROM  book_book_id WHERE `status`=1

-- );

/*具体书本信息，给前端的两脚兽看的*/
CREATE VIEW `book_book_id_vw`(context_id,book_name,book_name_id,book_id,borrow_status) AS (
	
	SELECT context_id,/*关系id 自增*/
		book_name, /*具体书名*/
		book_book_id.book_name_id,/*书名id*/
		book_id, /*图书编号  书名 id + A + 同书名第几本 （例：001A001）*/
		borrow_status /*图书当前状态：0：未出借 1：出借 2：逾期未还 3：损坏/遗失*/
	FROM  book_book_id,book_count WHERE book_book_id.book_name_id=book_count.book_name_id AND book_book_id.`status`=1 AND book_count.`status`=1

);

/*借阅记录表视图 也是给前台两脚兽看的*/
CREATE VIEW `borrow_history_vw`(borrow_id,book_name,user_id,book_id,borrow_date,return_date,return_status) AS(
	
	SELECT borrow_id,/*记录编号*/
		book_name,/*具体书名*/
		user_id,/*用户id*/
		borrow_history.book_id,/*图书编号*/
		borrow_date,/*借阅日期*/
		return_date,/*归还日期*/
		return_status /*书籍状态 0：未归还	1：已归还	2：损坏/遗失	3：已经补偿*/
	FROM borrow_history,book_book_id_vw WHERE borrow_history.book_id = book_book_id_vw.book_id AND borrow_history.`status`=1
)

/*书籍推荐视图*/
CREATE VIEW `book_communicate_vw`(book_communicate_id,book_communicate_name,book_communicate_synopsis,book_communicate_picture,username) AS(
	
	SELECT book_communicate_id,/*书籍推荐编号*/
		book_communicate_name,/*推荐书籍名*/
		book_communicate_synopsis,/*书籍简介，最大200字*/
		book_communicate_picture, /*书籍封面链接*/
		username/*书籍推荐者用户名*/
	FROM `book_communicate` WHERE `status`=1
)

/*用户评论视图*/
CREATE VIEW `user_comments_vw`(comments_id,username,user_comments,comments_date,book_communicate_id ) AS(

	SELECT user_comments.comments_id,/*书籍评论编号*/
		username,/*用户名*/
		user_comments,/*用户评论*/
		comments_date,/*评论日期*/
		book_communicate_id /*书籍推荐编号*/
	FROM user_comments WHERE `status`=1
	
)



/*=====================添加数据=======================*/

/*添加最高管理员账号*/
-- INSERT INTO `user` VALUES (0,'root','k382008072',2,1);

SELECT * FROM `user_vw`

INSERT INTO book_count(book_name,book_place,book_price,max_num) VALUES(#{bookName},#{bookPlace},#{bookPrice},#{maxNum});

SELECT * FROM book_count

SELECT * FROM book_count_vw

DELETE FROM book_count

SELECT * FROM book_book_id

SELECT * FROM book_book_id_vw


SELECT * FROM test_ptlb.book_count_vw


SELECT *FROM borrow_history_vw

SELECT *FROM borrow_history


SELECT * FROM book_communicate_vw
SELECT * FROM user_comments_vw

SELECT * FROM book_communicate

SELECT * FROM user_comments


