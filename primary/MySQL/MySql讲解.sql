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


第三讲：
	函数的使用 + 视图
	 数学函数：
		
	 时间函数：

	 字符串函数：

	 聚合函数：


	数学函数：
		abs(值) 绝对值
		round(x,y):返回参数x的四舍五入 有y位小数的值；
		greatest(x1,x2....) 返回集合中的最大值
		least(x1,x2....);返回集合中的最小值
		
		例如：
			use tyydb;
			select * from goods_table;
									
			select *,abs(goods_table.good_price) as absPrice ,
				round(goods_table.good_price,1) as rouPrice
		  from 
				goods_table;

			//取出最大值
			select GREATEST(12,33,523,22,21,2,343,2) as maxPrice

			select GREATEST(select good_price from goods_table) as maxPrice;

			select GREATEST(good_price) as maxPrice from goods_table;

		  select GREATEST(good_price) from goods_table;

			select GREATEST(-5999.99,
											6999.99,
											7999.99,
											-5999.99,
											6999.99,
											7999.99) as maxPrice;

		GREATEST(12,33,523,22,21,2,343,2);

select greatest(select order_type from t_order) as greatest_info;

	时间函数：
		time(字段/值) 
		year(字段/值)
		timestamp(时间) 完整时间
		from_unixtime(ts,fmt);根据fmt格式化时间；
	
		unix_timestamp('时间字符串');转换为时间戳
		
		DATE_FORMAT(now(),'%y-%m-%d %h:%i:%s');时间转换为字符串
		STR_TO_DATE('时间字符串','%y-%m-%d %h:%i:%s');将字符串 转换为时间格式

		select * from goods_table;
		//提前加字段
		alter table goods_table add good_beg_time timestamp;

		update goods_table set good_beg_time = '2014-5-20';

		

		//使用时间函数
		select time(good_date) as gtime from goods_table;
		select year(good_date) as gtime from goods_table;

		select timestamp(good_beg_time) as alltime from goods_table;

		select timestamp('2011-5-3') as alltime from goods_table;

		select unix_timestamp(good_date) as unixtime from goods_table;	
		
		select from_unixtime(1566263960,'%y-%m-%d %h:%i') as alltime from goods_table;	
		select from_unixtime(1566263960,'%y年%m月%d日 %h:%i') as alltime from goods_table;	
		// ,'%y-%m-%d %h:%i'

		select DATE_FORMAT(now(),'%y-%m-%d %h:%i') as alltime from goods_table;	

		STR_TO_DATE

		select good_date from goods_table;

		select STR_TO_DATE('2019-08-20 09:19:20','%Y-%m-%d') as alltime from goods_table;



		select *	from goods_table;



	 字符串函数：
			concat(字段/值);拼接字符串 
			CONCAT_WS("连接符",字段/值);通过连接符 拼接字段

			`LEFT`(str,len) 返回字符串左边长度字符
			 `RIGHT`(str,len);
			.......

			//使用
			select concat('我叫','张三丰','来自','武当山',',我今年','一百多岁！！！！') as stru_userinfo;

			select CONCAT_WS('===',good_id,
														good_name,
														good_num,
														good_type,
														good_price,
														good_date,
														good_beg_time
														) AS goods_info from goods_table;


		select LEFT(good_date,10) as sunTime from goods_table;

		select right(good_date,8) as sunTime from goods_table;


	聚合函数：
		avg();列的平均值
		COUNT();返回列数
		min();最小
		max();
		sum();列的数字和\
		.......

		select avg(abs(good_price)) as good_avg from goods_table;

		select COUNT(*) as good_count from goods_table;

		select COUNT(good_id) as good_count from goods_table;

		
		select min(abs(good_price)) as good_min from goods_table;

		select max(abs(good_price)) as good_max from goods_table;

			select sum(abs(good_price)) as good_sum from goods_table;

		//聚合 函数的简单使用
		select sum(abs(good_price)) as total_price,
					 avg(abs(good_price)) as avg_price,
					 min(abs(good_price)) as min_prive
		from goods_table
		where good_type = '2'

			
  ORDER BY :排序 
	select * from goods_table;
	select * from goods_table ORDER BY good_price DESC;
	select * from goods_table ORDER BY good_price asc;

	group by ：分组
	
	select 	good_name,
					sum(abs(good_price)) as total_price,
					avg(abs(good_price)) as avg_price,
					min(abs(good_price)) as min_prive
 from goods_table 
 group by good_type
 having total_price>10000;

 case  when 的使用：
	
	select * from t_student;
	//第一种：
	select *,
				 case 
						when t1.stu_age<=12 then '少年'
						when 12<t1.stu_age && t1.stu_age<=18 then '青少年'
						when 18<t1.stu_age && t1.stu_age<=28 then '青年'
						when 28<t1.stu_age && t1.stu_age<=48 then '中年'
						when 48<t1.stu_age && t1.stu_age<=68 then '老年'
					ELSE '垂暮之年'
					end as user_age_name
	from t_student t1;

	select * from goods_table;
	select *,
				 case t1.good_type
						when 1 then '电器'
						when 2 then '家具'
						when 3 then '床上用品'
						when 4 then '五金'
						when 5 then '建材'
						when 6 then '水果'
					else '杂货'
					end as type_name
	from goods_table t1;
	
	
	视图：
		视图的定义：是一张虚拟的表，用于查询赋值的 多表记录；
		优点：将复杂的查找操作，变成一张虚拟的表 进行重复 安全 简单 的操作；

		视图操作：
		格式：
			create view 视图名称(v_) as 查询语句;

			alter view 视图名称(v_) as 查询语句;

			drop view  视图名称(v_);

			select * from  视图名称(v_) 查询条件;

			例如：
			create view v_stu_cour_sco
				as 
			select 
				t1.stu_no,
				t1.stu_name,
				t1.stu_sex,
				t1.stu_age,
				t1.stu_birth,

				t2.score_id,
				t2.score,

				t3.course_id,
				t3.course_name
			from t_student t1 
			inner join 
			t_score t2 on t1.stu_no = t2.stu_no
			inner join 
			t_course t3 on t2.course_id = t3.course_id
			where t1.stu_name like '%小%';

		select * from v_stu_cour_sco;


select stu_name, round(DATEDIFF(DATE_FORMAT(NOW(),'%y-%m-%d'),stu_birth)/365) as 周岁 ,
 round(DATEDIFF(DATE_FORMAT(NOW(),'%y-%m-%d'),stu_birth)/365)+1 as 虚岁 
from t_student;

--统计男生，女生总分数，按照分数排序，递减。
select stu_sex ,SUM(achievement) from 
students stu , studentsrelationcourse src where 
stu.stu_num = src.stu_num GROUP BY stu.stu_sex ORDER BY SUM(achievement)desc




10. 统计张三学生的成绩的平均分,总分，最高分，最低分,考试门数
		

11.按照课程统计成绩的平均分,总分，最高分，最低分
		
		
12.按照课程统计成绩的平均分,总分，最高分，最低分，并查询最低分大于等于60分
		
13.按照课程统计成绩的平均分,总分，最高分，最低分，并查询最低分大于等于60    分，按照最高分降序排列
		
14.获取当前记录中最高分的记录
			

--查询学生信息+选择的课程+成绩  (通过(left)关联查询)
--查询每个学生的总成绩,按照成绩从高到低排序(sum, group by, order by函数);
--查询出每个学生的选择课程的总学时数（课程表加 学时字段）
--统计男生，女生总分数，按照分数排序，递减。
--通过出生日期 计算出学生的年龄
-- 检索数据	
 select * from t_student;
 select * from t_course;
 select * from t_score;






		




//练习：
5. 查询包含XXX课程的成绩;
	select * FROM	t_score t1 
	left join 
	t_student t2 on t1.stu_no = t2.stu_no
	left join
	t_course t3 on t1.course_id = t3.course_id
	where  t3.course_name = 'JAVA';
6. 查询某某同学所选科目成绩;
	select * from t_score t1
	left join 
	t_student t2 on t1.stu_no = t2.stu_no
	left join
	t_course t3 on t1.course_id = t3.course_id
	where t2.stu_name ='张三';


7. 查询参加某科目(java、 语文、 数学、)考试的学生姓名;
	select stu_name from t_student  where stu_no not in(
		select stu_no from t_score where course_id=
			(select course_id from t_course where course_name='JAVA')
	);
8. 查询没有参加某科目(java、 语文、 数学、)考试的学生信息；

9. 查询张三所选科目成绩，姓名，课程名称;
	select * FROM	t_score t1 
	left join 
	t_student t2 on t1.stu_no = t2.stu_no
	left join
	t_course t3 on t1.course_id = t3.course_id
	where  t2.stu_name = '张三';

	//子查询 实现功能
		select 
		(select stu_name from t_student where stu_no = sc.stu_no) as '姓名',
		(select course_name from t_course where course_id = sc.course_id)as '课程名',
		sc.score as '成绩'
		from t_score as sc
		where sc.stu_no = (select stu_no from t_student where stu_name ='张三');

-------------------------------------------------------
10. 统计张三学生的成绩的平均分,总分，最高分，最低分,考试门数
		

11.按照课程统计成绩的平均分,总分，最高分，最低分
	select 	course_id,
					avg(score) 平均分,
					sum(score) 总分,
					max(score) 最高分,
					min(score) 最低分
		from t_score group by course_id;
		
12.按照课程统计成绩的平均分,总分，最高分，最低分，并查询最低分大于等于60分
		select 	course_id,
					avg(score) 平均分,
					sum(score) 总分,
					max(score) 最高分,
					min(score) 最低分
		from t_score group by course_id having 	min(score)>60;
13.按照课程统计成绩的平均分,总分，最高分，最低分，并查询最低分大于等于60分，按照最高分降序排列
		select 	course_id,
					avg(score) 平均分,
					sum(score) 总分,
					max(score) 最高分,
					min(score) 最低分
		from t_score group by course_id 
		having 	min(score)>=60
		order by max(score) desc;
14.获取当前记录中最高分的记录
		select 	course_id,
					avg(score) 平均分,
					sum(score) 总分,
					max(score) 最高分,
					min(score) 最低分
		from t_score group by course_id 
		order by max(score) desc limit 1;

--查询学生信息+选择的课程+成绩 (通过(left)关联查询)
--查询每个学生的总成绩,按照成绩从高到低排序(sum, group by, order by函数);
	select t2.stu_name as '姓名', sum(t1.score) as '总成绩'  
	from 
	t_score t1 
	left join 
	t_student t2 on t1.stu_no = t2.stu_no
	group by 
	t2.stu_no
	order by sum(t1.score) desc;

--查询出每个学生的选择课程的总学时数(课程表加 学时字段)

--统计男生，女生总分数，按照分数排序，递减。
	select t1.stu_sex as 'SEX' ,sum(t2.score) as '总分数'
	from 
	t_student t1 
	LEFT JOIN
	t_score t2 on t1.stu_no = t2.stu_no
	
	group by 
	t1.stu_sex
	order by sum(t2.score) desc;

--通过出生日期 计算出学生的年龄
	FLOOR(X)
	CEIL(X)

	select  
		stu_name,
		stu_birth,
		DATEDIFF(DATE_FORMAT(now(),'%Y-%m-%d'),stu_birth)/365 as ageNum,
		FLOOR(DATEDIFF(DATE_FORMAT(now(),'%Y-%m-%d'),stu_birth)/365)  as '周岁',
		CEIL(DATEDIFF(DATE_FORMAT(now(),'%Y-%m-%d'),stu_birth)/365) as '虚岁'
	from
	t_student;

	select * from t_student;

	事物：
		事物特点：
			原子性..。
			一致性..。
			隔离性。。
			持久性...
		一连串需要操作，需要改变数据原始状态的 一个完整的业务逻辑；

	具体操作：
		开启事物：begin/ start TRANSACTION
		提交事物:COMMIT	
		回滚事物：rollback
		设置回滚点:savepoint point_1
		回滚到某个点：rollback to savepoint 点名称
		事物终止：set autocommint = 0;
 
   //事物案例操作	
		select * from  t_student;
		
		//添加  修改   删除
		start transaction; 
		/*insert into t_student values (null,'刘德华','M',60,'1947-10-14');
		insert into t_student values(null,'刘晓庆','W',55,'1957-10-14');
		insert into t_student values(null,'周润发','M',65,'1967-10-14');

		设置回滚点
		savepoint point_insert;
		
		update t_student set stu_name = '马云' where stu_name like '小%'; 

		savepoint point_update;
		savepoint point_delete;
		*/
		delete from t_student where stu_sex = 'M';
		set autocommit = 0;
		-- SET AUTOCOMMIT,START TRANSACTION
		-- rollback;
		-- commit;

		select * from t_student;

		rollback;
		
		rollback to point_insert;
		
		
























