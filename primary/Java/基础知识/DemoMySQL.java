package jdbc;

/**
1、	什么是JDBC？
	JDBC（Java DataBase Connectivity,java数据库连接）是一种用于执行SQL语句的Java API，
		可以为多种关系数据库提供统一访问，它由一组用Java语言编写的类和接口组成。
2、	使用JDBC连接数据有哪四种方式？
	（1）JDBC-ODBC桥加ODBC驱动程序 
		JavaSoft桥产品利用ODBC驱动程序提供JDBC访问。
	（2）本地API 
		这种类型的驱动程序把客户机API上的JDBC调用转换为Oracle、Sybase、Informix、DB2或其它DBMS的调用。
	（3）JDBC网络纯Java驱动程序 
		这种驱动程序将JDBC转换为与DBMS无关的网络协议，之后这种协议又被某个服务器转换为一种DBMS协议。
	（4）本地协议纯Java驱动程序 
		这种类型的驱动程序将JDBC调用直接转换为DBMS所使用的网络协议。这将允许从客户机机器上直接调用DBMS服务器，
		是Intranet访问的一个很实用的解决方法。
	
3、	DriverManger类有什么作用？
	DriverManager类是JDBC的管理层，作用于用户和驱动程序之间。它跟踪可用的驱动程序，
	并在数据库和相应驱动程序之间建立连接。DriverManager 类也处理诸如驱动程序登录时间限制
	及登录和跟踪消息的显示等事务。DriverManager 类包含一列的驱动程序类，它们已通过调用方法
	DriverManager.registerDriver( ) 对自己进行了注册，所以我们可以直接加载驱动程序，
	然后让驱动程序自己去注册。

4、	ResultSet如何获取查询结果？
	把查询的结果保存在list对象里，直接调用list.size()就可以了。
5、	Statement接口有什么作用？
	用于执行静态的sql语句 
		1）int executeUpdate(String sql) ： 执行静态的更新sql语句（DDL，DML） 
		2）ResultSet executeQuery(String sql) ：执行的静态的查询sql语句（DQL）
6、	什么是事务？
	事务是应用程序中一系列严密的操作，所有操作必须成功完成，否则在每个操作中所作的所有更改都会被撤消。
	也就是事务具有原子性，一个事务中的一系列的操作要么全部成功，要么一个都不做。
	数据库事务 transanction 正确执行的四个基本要素。ACID,原子性(Atomicity)、一致性(Correspondence)、
	隔离性(Isolation)、持久性(Durability)。
7、	如何使用Transaction完成事务操作？
	开启事务：Start Transaction
	事务结束：End Transaction
	提交事务：Commit Transaction
	回滚事务：Rollback Transaction
 * 	commit:提交
	rollback：回滚

 * 
 * 
	JDBC接口核心的API：
	
	1、Driver接口： 表示java驱动程序接口。所有的具体的数据库厂商要来实现此接口。 
		1）connect(url, properties): 连接数据库的方法。 
		url: 连接数据库的URL 
		URL语法： jdbc协议:数据库子协议://主机:端口/数据库 
		user： 数据库的用户名 
		password： 数据库用户密码
	
	2、DriverManager类： 驱动管理器类，用于管理所有注册的驱动程序 
		1）registerDriver(driver) : 注册驱动类对象 
		2）Connection getConnection(url,user,password); 获取连接对象
	
	3、Connection接口： 表示java程序和数据库的连接对象。 
		1）Statement createStatement() ： 创建Statement对象 
		2）PreparedStatement prepareStatement(String sql) 创建PreparedStatement对象 
		3）CallableStatement prepareCall(String sql) 创建CallableStatement对象
	
	4、Statement接口： 用于执行静态的sql语句 
		1）int executeUpdate(String sql) ： 执行静态的更新sql语句（DDL，DML） 
		2）ResultSet executeQuery(String sql) ：执行的静态的查询sql语句（DQL）
	
	5、PreparedStatement接口（Statement接口的子接口）：用于执行预编译sql语句 
		1） int executeUpdate() ： 执行预编译的更新sql语句（DDL，DML） 
		2）ResultSet executeQuery() ： 执行预编译的查询sql语句（DQL）
	
	6、CallableStatement接口（PreparedStatement接口的子接口）：用于执行存储过程的sql语句（call xxx） 
		1）ResultSet executeQuery() ： 调用存储过程的方法
	
	7、ResultSet接口：用于封装查询出来的数据 
		1）boolean next() ： 将光标移动到下一行 
		2）getXX() : 获取列的值

 *
 * */


public class DemoMySQL {

}
