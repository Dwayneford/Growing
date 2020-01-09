1.Oracle简介
2.oracle的基本使用
3.Oracle的常用命令
4.oracle的用户管理
5.oracle的权限管理

  1.Oracle简介
    数据库的类型之分？
    数据的大小之分？
    如何区别 数据库的大小？
    
  2.oracle的基本使用
    安装oracle数据库......
    启动应用：oraclerserviceOracle 服务
    启动监听：oracleoraDB11g_home2TNSLlistener 通过第三方工具 链接数据库 服务项目
    
    安装可视化 工具：netWork、pl/sql
    
    oracle 安装完成后 系统 有默认的三个用户：
           sys 数据库管理员
           system 操作员，安装设置的密码
           scott 测试账号 默认密码 tiger
                 scott:默认是锁定状态
                 
           小白用户      
                 
   3.Oracle的常用命令            
         链接数据库：sqlplus/ as sysdba
         用户名 密码
           
         显示用户：show user
         
         切换用户：conn 用户名/密码【as sysdba】
         
         解锁：alter user 用户名 account unlock;
               去解锁的用户 必须有相应得权限;
               
         锁定：alter user 用户名 account lock;     
         
         修改秘密：
                  passw[ord] 密码
                  
         修改其他用密码：
                  alter user 用户 identified by 新密码;
                  
          断开当前用户
             disc
             
                设置显示 数据行数 ：set pagesize 数字 【默认14行】
                设置显示多少字符：set linesize 数字 【默认显示80个】
                
          清空窗口：clear screen;
                
          退出：exit;      
          
       4.用户管理：
          创建用户：create user 用户名 identified by 密码;
          删除用户：drop user 用户名;
          
       5. 权限管理
           权限：对系统 授予操作设置 的一些相关功能
                  系统权限/对象权限(已角色的形式赋予)
                  
                  一般开发用户 授予基本操作 角色
                         connect 和 resource;
                             
                  DBA角色:数据库的所有权限;
                  connect:用户链接 数据库的权限
                  resource：具有程序开发 的角色用到的相关权限；
                     具体 包含：
                        create trigger-- 建立触发器
                        create sequence 建立序列
                        create type 建立类型
                        create procedure 建立过程
                        create cluster 建立聚簇
                        create operator 创建操作者
                        create indextype 创建索引类型
                        create table 键表
                        .......
                        
                  如何使用权限？
                        给用户 授权：
                            系统权限：grant 权限名称 to 用户 [with admin option];
                            对象 权限：grant 对象权限[insert,delete  update,select] on 表名 to 用户名  [with admin option];
                            
                         
                                授权 全部权限：
                                grant all privileges on scott.emp from 用户名;
                           将对象  权限 回收： 
                                revoke select on scott.emp from  用户名;
                             
                            系统权限 回收：
                                 revoke connect from      用户名;
                            
                            
                            
      第二讲：
          1. Oracle的体系结构
          2.表空间
          3.用户管理
          4.权限 管理
          5.角色管理
                   
       1. Oracle的体系结构      
          数据库结构
          
               物理存储结构：在操作系统中 数据 已文件的形式存在
                          存放文件的结构组成：
                             数据文件：后期产生的数据内容
                             控制文件：存放和数据库本身相关的一些数据
                             日志文件：存放操作过程中的日志记录
                
               逻辑存储结构：数据在数据库中的存储关系;
                             从层次角度分析：
                                表空间：存放表 对象 索引 等数据 到磁盘空间
                                逻辑对象：存放表 对象 索引 视图 过程 的结构；
                                段：指定类型的存储结构; eg:创建表(数据段) 创建索引(索引段)
                                区间：被分配和释放的一个空间,最小的存储单元
                                数据块：基本的结构管理；                           
                     
                               从上到下：是大到小的结构组成；
                               
                                      
               
        2.表空间
              创建表空间
               create tablespace 表空间名称 datafile 路径 size 兆;
               
              临时表空间：
               create temporary tablespace 临时表空间名称 tempfile 路径 size 兆;                                    
                  
               
              修改大小：
               alter tablespace  空间名称 add datafile     路径 size 兆;
               
               默认指定：alter database default tablespace   空间名称;
               
          删除：
               drop tablespace 空间名称;  逻辑删除 表空间
               
               drop tablespace 空间名称 including contents; 逻辑删除 表空间 和 段
               
               drop tablespace 空间名称 including contents and datafiles; 逻辑删除 表空间 和 段 及其数据
               
         3.用户管理      
           创建用户：
               create user  用户 identified  by 密码 [default tablespace 空间名称][temporary tablespace 临时表空间]
               
               查询 用户 所属的表空间：
                  select * from dba_users where username='大写用户名';    
                  
                  select * from dba_users where username='SYSTEM';   
               删除:
               DROP USER 用户名;           
               
               
           
           角色管理：包含多个权限的一个集合
               系统 角色：.........
               
               自定义 角色：
                   创建：create role 角色名
                   给角色授权：grant 权限 to 角色名
                   给用户授予角色：grant 角色名 to 用户名;
                   删除角色：drop role 角色名;
                   
                   
                   
      练习：
           1.建立表空间 + 临时表空间
           2.建用户 指定要表空间 
           
           3.查看用户属于哪个表空间
           4.创建表 用户建表 学生表 商品表。。。。
           
           5.加注释 写数据 .......
           6.写序列 同义词 视图 索引......
           
           7.修改 数据 修改序列.......
           
              
        -- 创建表空间
        create tablespace testSpace datafile 'd:\test.dbf' size 10M;
        create temporary tablespace tempTestSpace tempfile 'd:\tempTest.dbf' size 5M;       
        
        -- 修改大小
        
        -- 删除操作
        
        
        -- 创建用户
        create user testUser identified by 123456 
               default tablespace testSpace 
               temporary tablespace tempTestSpace;
        
        
        -- 查询 用户属于的表空间
        select * from  dba_users where username='TESTUSER';
        
        
        -- 授权：
        grant dba to testUser with admin option;
        
        
        drop table studentInfo;
        
        -- 创建表操作
        create table studentInfo(
               id number(10) primary key not null,
               name varchar2(30)  not null,  -- unique
               password varchar2(100) not null,
               sex char(2) check(sex='男' or sex='女') not null,
               age number (3) not null,
               birthday date,
               address varchar2(200)
        );
        
        show user;
        
        -- 添加表注释
        comment on table studentInfo is '学生信息表';
        
        -- 字段注释
        comment on column studentInfo.id is '主键 Id';
        comment on column studentInfo.name is '学生姓名';
        comment on column studentInfo.age is '学生 年龄';
        
        -- 插入数据
        insert into studentInfo values (seq_sid.nextval,'江小白','123456879','男',20,date'2019-10-25','重庆市——高兴区');
        insert into studentInfo values (seq_sid.nextval,'刘德华','123ABC9','男',66,date'2019-10-25','重庆市——高兴区222');
        
        -- 事物 没提交
        commit;
        
        select * from studentInfo;
        seq_sid.nextval,seq_sid.nextval,
        
        
        -- 同义词： 给查询的实体取一个别名
        create or replace synonym stio for studentInfo;

        select * from stio;
        
        
        -- 视图操作
        create  or replace view v_stu_info
                as
                -- 查询 SQL语句
                select * from studentInfo;
       select * from  v_stu_info
        
       -- 索引操作
       create index i_stu_sex on studentInfo(sex);
       
       select * from studentInfo where sex ='男';
       
       -- 序列操作
       create sequence seq_sid
       start with 3
       increment by 1
       minvalue 3
       
       
       -- 存放数据
       insert into studentInfo values (seq_sid.nextval,'jiangxiaobia','123456879','女',20,sysdate,'CQ_GXQ');
       commit;
        
       
       第三讲：
             Oracle中的 数据类型
             
             同义词
             
             视图的使用
             
             索引的使用
              
             序列的使用 
             
             
             函数 过程 触发器.....
             
             
            1. Oracle中的 数据类型 
             number(m,[n]) 数字类型
                    m:数字个数 38位
                    n：小数
                    
                    number(5) :范围 -99999 ~~~99999
                    number(5,1) 范围：-9999.9 ~~~9999.9
                    
             integer 整数类型
             char 固定字符长度类型 最大：255个字符
             varchar2() 可变字符 4000
             long: 字符类型：最大2G
             lob: 大数据类型： 4G
             date:时间类型
             
             同义词的使用：
                 给实体取别名：为 私有/共有 
                 
                 创建：create 【or replace】 [public] synonym 别名 for 表名
                 删除：drop [public] synonym 别名 ;
                 
                 
             视图的使用
                 创建：create [or replace] view 视图名称 as 查询的sql语句;
                 使用：select * [字段] from 视图名称 条件查询  分组操作 排序 统计 ......
                 删除：drop view  视图名称;
                 
             创建索引：
                 创建：create index 索引名称 on 表名(字段)
                 删除：drop index 索引名称; 
                 
                 
             序列的使用
                 sql 主键 通常是自动增长，不需要手动提供该字段的值
                 
                 创建序列 格式：
                       create sequence sql_序列名称
                              start with 初始值
                              increment by 增量
                              minvalue 最小值
                              maxvalue 最大值
                              cycle 如果达到最大值，重新开始| nocycle (默认)不重新开始
                              cache 值 （缓存量：默认为20）| nocache (没有缓存)
                              
                              
                 删除序列：drop sequence 序列名称;
                 
                 
                 --- 自己 使用
                 
                 Oracle 中的函数 ：系统函数  自定义 函数
                 
                  1 字符串函数
                    lower(n)
                    upper(n)
                    ltrim(n)
                    rtrim(n)
                    length(n)  
                    replace(m,n,k) 将m中的k 替换为k
                    .............
                  
                  2 数学函数
                    abs()
                    ceil(n) 取 大于等于n的最小整数
                    
                    floor(n) 小于等于n的最小整数
                    round(n,m) 四舍五入
                    trunc(n,m) 对n进行截取 m个长度
                    .....
                     
                  
                  
                  3 转换函数
                    to_number(n,m) 将字符n按照 m 的格式转换为数字类型；
                    eg:'45218.45565698', 000.00
                    
                    to_char(n,m) 
                    
                    to_date(n,m)
                  
                    nvl(n,m) :三目运算
                    
                    nvl2(n,m,k):
                    
                    
                  .......
                 
                oracle中的查询操作：
                  ....................
                           
                  
                  
               oracle中的事物操作
                  事物是保证数据库中 数据的一致性，要么全部成功 要不全部失败；
                  
                  提交事物:commit;
                  回滚事物：rollback;
                  设置保存点: set savepoint  名称;
                  回滚到保存点：rollback to 名称；
                  
              oracle 中的存储过程：
                    存储过程：类似于 程序中的方法 用于封装一些带有业务逻辑的执行SQL语句；
                    
                    
                    格式：创建存储过程
                    create or replace procedure pro_过程名称(参数1 [模式] 参数类型,
                                                             参数2 [模式] 参数类型....)   
                       is/as
                          定义变量的区域
                                                                
                       begin
                          sql 语句区域
                                                                    
                       end;
                              
                  模式：输入/输出参数   in 输入  out 输出 默认为 in   
                  
                  
                  调用方式：
                       declare 
                            定义变量;
                           begin
                               调用过程
                             end;        
                              
                              
                              
                oracle 中的函数
                       作用 用户oracle中的过程类似；
                       create or replace function fun_函数名称(参数名 数据类型,......)
                              return 返回值类型;
                              is/as
                                     定义变量的区域
                              begin
                                 sql语句区域
                                 return 放回值;
                                end;
                                
                                
                      调用：
                      select fun_函数名称(参数列表) from dual; dual是oracle中的默认站位标识符;          
                           
                      
      案例实现：====>
            select * from studentInfo;  
            -- 字符串函数
            select lower('Java_123CLASS') as 小写 from dual;    
            select upper('Java_123CLASS') as 大写 from dual;   
                           
            
           select ltrim('    Java_123CLASS   ') as 去掉左边空格 from dual;   
                            
           select length('    Java_123CLASS   ') as 长度 from dual;   
                    
           select ltrim(rtrim('    Java_123CLASS   ')) as 去掉空格 from dual;            
        
           select replace('小白','白','花花') from dual;
       
       
      
         select * from scott.emp;    
         select lower(ename) as 小写 from scott.emp;    
         
         -- 字符串 拼接
         concat(str1,str2,str3....)
         
         select concat('我是','一个') as 拼接字符串 from dual;    
         
         -- 数学函数....
         select ceil(3.12) from dual;
         
         select floor(3.12) from dual;
         
         -- 转换函数
         select to_number('3.1415') from dual;
         
         select to_char(sysdate,'yyyy-MM-dd HH:mm:ss') from dual; 
         select to_date('20-01-09','yyyy/MM/dd') from dual;
         
         nvl2()
         
         
         select * from scott.emp;   
         select * from scott.dept;
         update scott.emp set comm= nvl2(comm,comm+100,300);
         
         
         oracle 中的常用SQL操作 与其他SQL语句 类似
         
         1. 计算 每个人的年薪
         select empno ename, sal*12+nvl(comm,0) from scott.emp;
         
         2.部门下的所有员工
         select * from scott.emp t1
            inner join scott.dept t2
            on  t1.deptno = t2.deptno where t2.dname='SALES'; 
            
            
         select * from scott.emp where  deptno in (
                select deptno from scott.dept where dname='SALES'
         );
         
         ..................................
         
         
         -- 事物 操作
         
            -- 插入数据
        insert into studentInfo values (seq_sid.nextval,'刘若英','123456879','女',30,date'1989-10-25','台湾');
        savepoint a;
        insert into studentInfo values (seq_sid.nextval,'周星驰','123ABC9','男',66,date'1899-10-25','香港');
       
      
        savepoint b;
        insert into studentInfo values (seq_sid.nextval,'张飞','123ABC9','男',66,date'1899-10-25','香港');
        -- 事物 没提交
        -- 回滚
        rollback to b;
        -- rollback;
        commit;
         
        select * from studentInfo;
         
        
       -- 自定义:过程 函数
       create or replace procedure pro_out_time
       is
       begin
         --输出
         dbms_output.put_line('当前时间为:'||to_char(sysdate,'yyyy-MM-dd'));
         end;
         
         
         --调用 
         begin 
           pro_out_time;
           end;
        
          
         -- 插入数据 
         -- SELECT * FROM USER_ERRORS WHERE NAME='存储过程名称'
         select * from scott.emp;
         
         drop procedure pro_insert_emp;
          --scott.
         create or replace procedure scott.pro_insert_emp
         (
                id number,
                name varchar2,
                gz number   
         )
         is 
         begin
                -- 添加操作
                insert into scott.emp(empno,ename,sal)values(id,name,gz);  
                commit;
           end;
         
        -- 授权：
        grant dba to testUser with admin option;
        
        --  调用
        declare
            id number;
            name varchar(20);
            gz number;
            
            begin
              id:=51;
              name:='小红';
              gz:=9000;
              --调用
              pro_insert_emp(id,name,gz);
            end;
            
            
            
          
        
        -- 调用方式二
        begin 
            pro_insert_emp(52,'小黄',8596);
        end;
                 
       -- 调用 方式三
        begin 
            pro_insert_emp(id=>53,name=>'小马',gz=>8596);
        end;             
     
   
        --创建 方式二
        create or replace procedure pro_insert_emp_1
        (
               id emp.empno%type,
               name emp.ename%type,
               gz emp.sal%type
               
        )
        is
        begin
           -- 添加操作
           insert into scott.emp(empno,ename,sal)values(id,name,gz);  
           commit;
        end;
        
        -- 调用方式
        declare
           id number:=54;
           name varchar2(20):='小环';
           gz number:=8001;
        begin
           pro_insert_emp_1(id,name,gz);
        end;   
        
           
       -- 输出：根据用户名 查询 编号 和工作
       create or replace procedure pro_select_emp(
              name emp.ename%type, id out number,gz out number
       )    
       is
       begin
          -- 查询
          select  empno,sal into id,gz from emp where ename=name;
       end;
        
       
       --调用
       declare 
          name varchar2(20):='小环';
          id number;
          gz number;
          
          begin
             pro_select_emp(name,id,gz);
             
             -- 输出
             dbms_output.put_line('编号为：'||id);
             dbms_output.put_line('工资为：'||gz);
          end;
       
        
        
       select * from emp;     
                   
               
                     
                 
               
                          
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
  
                               
                        
                        
                        
                       
                         
    
    


