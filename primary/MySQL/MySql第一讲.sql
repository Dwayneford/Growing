第一讲：
	1 数据库的说明
	2 为什么 使用MySQL数据库
	3 如何使用
	4 MySQL中的存储引擎？
	5 MySQL中的 数据类型
	6 MySQL的 类型 属性

1.数据库的说明  从大到小：
		大型：oracle > db2 > sybase.....
		
		中型：sqlserver (.net 一般项目 一般公司)
		
		小型：mysql

如何区分数据库 的大小：通过请求数据库，它的响应速度，数据库的执行效率，检索数据，数据库响应时间；
											 不能根据数据库的 数据量确定；

2.为什么 使用MySQL数据库
	是一个关系型数据库，相比于其他数据库，简单易学...
  性能调试非常好，处理速度快
	开源 免费试用。
	有很多开源社区 和开源文档。
.......

3 如何使用
	安装 数据库 （官网现在）
	安装 客户端....

	命令：启动数据库
			net start /stop mysql (计算机管理中的服务 名称)
		
  创建数据库 创建表？
			通过 脚本命令创建
			通过 可视化工具 创建
		
4 MySQL中的存储引擎？
			InnoDB：默认 事务型 存储引擎
					适用于：更新密集型表，处理多重更新并发请求；
					 金融  用户订单  用户注册.....
			
			MEMORY:为了提高数据的操作速度，使用物理介质作为存取数据的临时空间；
						 使用这种操作 提高操作速度同时存在一些问题？
							数据丢失  存放时间过长，程序 系统自动清除
												突然情况 造成数据的丢失；
					适用于：存放安全级别不太高的数据；。。。。。。

		  MyISAM：存储的表独立于操作系统，可以轻松移植到其他无服务中；
				  适用于：选择密集型的表，从大量的数据中 迅速进行赛选。
									插入密集型表，
								
								航班信息，日志记录，邮件信息.....

5 MySQL中的 数据类型(重要)

		时间类型：
				date 日期类型
				datetime:日期+时间
				time：时间
				timestamp：完整的当前时间表示

		数值类型：
			bigint：大整数
			int:整数
			mediumint：第三大整数类型
			smallit：第四大整数类型
			tinyint:最下整数
			
			boolean：
			double:
			float:

		字符串类型：
			char:长度 固定 不足时默认空格填充，最多255个字符;
			varchar: 可变长度字符串：0~65536，
			blob:存放二进制数据 010010101011010101(转换后的视频 或者 图片...)
			text: 文本类型数据；
			lontext:最大 最大的数据 存放该字段；

6 MySQL的 类型 属性
		自动增长：auto-increment
		默认值:DEFAULT
		s索引：index

		不为空：not NULL	
		列主键：primary KEY
		填充0：zerofill
		.......
		
第二讲：
	1 数据库 和 表操作：
	2 数据操作
	3 高级SQL应用
	4 管理mysql

1 数据库 和 表操作：
		创建数据库：
			create database 数据库名称 default 编码格式 (character set utf8)
			collate utf8_general_ci;

	eg:
			create database tyydb default  character set utf8
			collate utf8_general_ci;

 // 切换 数据库：
 --  
 /*

  */
	use tyydb;
  
  // 删除数据库
	drop database 数据库名称;
	drop database tyydb;

// 表创建
	create table 表名(字段名称 数据类型[长度] 属性[默认值 存储引擎 注解 注释 编码格式....],
										字段名称 数据类型[长度] 属性[默认值 存储引擎 注解 注释 编码格式....],
										字段名称 数据类型[长度] 属性[默认值 存储引擎 注解 注释 编码格式....]....);
use jddb;
eg:
	create table goods_table(
				good_id int(11) not null primary key auto_increment,
				good_name varchar(100) default NULL,
				good_num int(3),
				good_type char(6),
				good_price double,
				good_date timestamp
		)charset=utf8,engine=innodb;

		create table goods_type(
				type_id int(11) not null primary key auto_increment,
				type_name varchar(100) default NULL
				
		)charset=utf8,engine=innodb;

 插入入数据：
insert into goods_table(
														good_name,
														good_num,
														good_type,
														good_price,
														good_date
														) values ('笔记本',500,'电器',5999.99,'2019-8-10 12:25:14')
														,('笔记本1',501,'电器',6999.99,'2018-8-10 12:25:14')
														,('笔记本2',502,'电器',7999.99,'2017-8-10 12:25:14');

insert into goods_table values (null,'笔记本3',500,'电器',5999.99,'2019-8-10 12:25:14')
														,(null,'笔记本4',501,'电器',6999.99,'2018-8-10 12:25:14')
														,(null,'笔记本5',502,'电器',7999.99,'2017-8-10 12:25:14');



// 复制表 结构  + 表数据
create table 新表名称 select *[可以选取部分字段] from 旧表： 
注意：只能复制表结构+数据，不能复制键

select * from goods_table;

create table goods_table_new select * from goods_table;

select * from goods_table_new;

//修改表 字段（重要）
  alter table 表名  add 字段名称 数据类型 属性;

	eg:
	alter table goods_table_new  add good_img varchar(255) not null;

  alter table 表名  change 旧字段 新名称 数据类型 属性;

	eg：
	alter table goods_table_new  change good_img good_user char(50) default NULL;

	//删除
	alter	table 表名 drop 字段名;
	
	alter	table goods_table_new drop good_user;
  
	select * from goods_table_new;

	//添加主键
	alter table 表名 add primary key(字段名称);
	eg:
	alter table goods_table_new add primary key(good_id);

  //修改名称 表名
	alter table 表名 rename to  新名

	alter table goods_table_new rename to  goods_rname_table;
	
	select * from goods_rname_table;
  .....

  //添加数据的 几种方式:
	insert into 表名([字段]) values (列表值);
	insert into 表名([字段]) values (列表值),(列表值),(列表值)....;
	
	insert into 表名 set 字段=值,字段=值,字段=值,字段=值,.....;
	
	insert into 表1 select * from 表2;

	//修改
	update 表名 set 字段=值,字段=值,字段=值... where 条件表达式; //having 筛选数据，使用聚合函数后
  
	//删除数据
	delete from 表名 where 条件表达式;

	//查询操作
	select * from 表名 where 条件表达式；

	select 字段1，字段2，字段3，字段4....., from 表名 where 条件表达式；

DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(20) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('1001', 'CSS');
INSERT INTO `t_course` VALUES ('1002', 'JAVA');
INSERT INTO `t_course` VALUES ('1003', 'JAVAWEB');

DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `stu_no` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(20) NOT NULL,
  `stu_sex` char(2) NOT NULL,
  `stu_age` int(11) NOT NULL,
  `stu_birth` date NOT NULL,
  PRIMARY KEY (`stu_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1001', '张三', '男', '23', '1987-10-14');
INSERT INTO `t_student` VALUES ('1002', '李四', '女', '13', '2004-10-14');
INSERT INTO `t_student` VALUES ('1003', '赵六', '男', '30', '1988-10-14');


第三讲：
	高级查询：多表操作.....
		
	取出 表中部分数据：
	select * from goods_table WHERE good_id >1 and 	good_id< 6;
	select * from goods_table WHERE good_id between 2 and 10;

   
  // limit;
	select * from goods_table limit 0,4;
	select * from goods_table limit 4,4;


	链接查询：将两张 多张表的数据结合起来查询 合并显示数据;

			3.1 交叉链接：返回两张表的 笛卡尔积；
					格式:SELECT *[需要的字段] from 表1，表2.....;
					select * from t_student;
					select * from t_course;

					select * from t_student,t_course;
		
			3.2 内链接：取出两张表中相交的数据
					格式:SELECT *[需要的字段] from 表1 inner join 表2... 链接条件;
		
					select *, t1.stu_name as sName from t_student t1
					inner join 	
						t_score t2 on t1.stu_no = t2.stu_no
					inner join 
						t_course t3 on t2.course_id = t3.course_id;

			3.3 左/右外链接
				格式:SELECT *[需要的字段] from 表1 left /right join 表2... 链接条件;
				select *, t1.stu_name as sName from t_student t1
					left join 	
						t_score t2 on t1.stu_no = t2.stu_no;
				select *, t1.stu_name as sName from t_student t1
					right join 	
						t_score t2 on t1.stu_no = t2.stu_no;
				
		insert into t_student values(null,'小白','男',20,'1995-10-15'),
																(null,'小红','男',20,'1995-10-15'),
																(null,'小花','男',20,'1995-10-15');
		select * from t_student;
	
	条件：要求表与表之间必须有关联关系，一般使用主键 和外界 进行关联；

	3.4 子查询 操作
			select * from 表;

			select * from (数据结果集) 别名;

			eg:
			select * from (
						select * from goods_table where good_price>6000
						) t1    //where ......                  

	3.5  模糊匹配
			select * from 表名 where 字段 like ?;
	
			格式：'%匹配字段%', '%匹配字段','匹配字段%','___匹配字段',
			select * from goods_table;
			select * from goods_table where good_name like '%本';
			select * from goods_table where good_name like '%本%';

			select * from goods_table where good_type like '___器';

学生表：
stu_no
stu_name
stu_sex
stu_age
stu_birth

成绩表：
score_id
stu_no
course_id
score

课程表：
course_id
course_name

1. 按字段，别名方式查询数据;

2. 查询 学生编号大于1002 姓名为某某的数据;

3. 查询出生年龄 在1998-10-15 到 2012-10-12之间的学生;

4. 查询姓名中含有'三'的学生;

5. 查询包含XXX课程的成绩;
	
6. 查询某某同学所选科目成绩;

7. 查询参加某科目(java、 语文、 数学、)考试的学生姓名;

8. 查询没有参加某科目(java、 语文、 数学、)考试的学生信息；

9. 查询张三所选科目成绩，姓名，课程名称;






		

									
	
	

		



































