1.Oracle���
2.oracle�Ļ���ʹ��
3.Oracle�ĳ�������
4.oracle���û�����
5.oracle��Ȩ�޹���

  1.Oracle���
    ���ݿ������֮�֣�
    ���ݵĴ�С֮�֣�
    ������� ���ݿ�Ĵ�С��
    
  2.oracle�Ļ���ʹ��
    ��װoracle���ݿ�......
    ����Ӧ�ã�oraclerserviceOracle ����
    ����������oracleoraDB11g_home2TNSLlistener ͨ������������ �������ݿ� ������Ŀ
    
    ��װ���ӻ� ���ߣ�netWork��pl/sql
    
    oracle ��װ��ɺ� ϵͳ ��Ĭ�ϵ������û���
           sys ���ݿ����Ա
           system ����Ա����װ���õ�����
           scott �����˺� Ĭ������ tiger
                 scott:Ĭ��������״̬
                 
           С���û�      
                 
   3.Oracle�ĳ�������            
         �������ݿ⣺sqlplus/ as sysdba
         �û��� ����
           
         ��ʾ�û���show user
         
         �л��û���conn �û���/���롾as sysdba��
         
         ������alter user �û��� account unlock;
               ȥ�������û� ��������Ӧ��Ȩ��;
               
         ������alter user �û��� account lock;     
         
         �޸����ܣ�
                  passw[ord] ����
                  
         �޸����������룺
                  alter user �û� identified by ������;
                  
          �Ͽ���ǰ�û�
             disc
             
                ������ʾ �������� ��set pagesize ���� ��Ĭ��14�С�
                ������ʾ�����ַ���set linesize ���� ��Ĭ����ʾ80����
                
          ��մ��ڣ�clear screen;
                
          �˳���exit;      
          
       4.�û�����
          �����û���create user �û��� identified by ����;
          ɾ���û���drop user �û���;
          
       5. Ȩ�޹���
           Ȩ�ޣ���ϵͳ ����������� ��һЩ��ع���
                  ϵͳȨ��/����Ȩ��(�ѽ�ɫ����ʽ����)
                  
                  һ�㿪���û� ����������� ��ɫ
                         connect �� resource;
                             
                  DBA��ɫ:���ݿ������Ȩ��;
                  connect:�û����� ���ݿ��Ȩ��
                  resource�����г��򿪷� �Ľ�ɫ�õ������Ȩ�ޣ�
                     ���� ������
                        create trigger-- ����������
                        create sequence ��������
                        create type ��������
                        create procedure ��������
                        create cluster �����۴�
                        create operator ����������
                        create indextype ������������
                        create table ����
                        .......
                        
                  ���ʹ��Ȩ�ޣ�
                        ���û� ��Ȩ��
                            ϵͳȨ�ޣ�grant Ȩ������ to �û� [with admin option];
                            ���� Ȩ�ޣ�grant ����Ȩ��[insert,delete  update,select] on ���� to �û���  [with admin option];
                            
                         
                                ��Ȩ ȫ��Ȩ�ޣ�
                                grant all privileges on scott.emp from �û���;
                           ������  Ȩ�� ���գ� 
                                revoke select on scott.emp from  �û���;
                             
                            ϵͳȨ�� ���գ�
                                 revoke connect from      �û���;
                            
                            
                            
      �ڶ�����
          1. Oracle����ϵ�ṹ
          2.��ռ�
          3.�û�����
          4.Ȩ�� ����
          5.��ɫ����
                   
       1. Oracle����ϵ�ṹ      
          ���ݿ�ṹ
          
               ����洢�ṹ���ڲ���ϵͳ�� ���� ���ļ�����ʽ����
                          ����ļ��Ľṹ��ɣ�
                             �����ļ������ڲ�������������
                             �����ļ�����ź����ݿⱾ����ص�һЩ����
                             ��־�ļ�����Ų��������е���־��¼
                
               �߼��洢�ṹ�����������ݿ��еĴ洢��ϵ;
                             �Ӳ�νǶȷ�����
                                ��ռ䣺��ű� ���� ���� ������ �����̿ռ�
                                �߼����󣺴�ű� ���� ���� ��ͼ ���� �Ľṹ��
                                �Σ�ָ�����͵Ĵ洢�ṹ; eg:������(���ݶ�) ��������(������)
                                ���䣺��������ͷŵ�һ���ռ�,��С�Ĵ洢��Ԫ
                                ���ݿ飺�����Ľṹ����                           
                     
                               ���ϵ��£��Ǵ�С�Ľṹ��ɣ�
                               
                                      
               
        2.��ռ�
              ������ռ�
               create tablespace ��ռ����� datafile ·�� size ��;
               
              ��ʱ��ռ䣺
               create temporary tablespace ��ʱ��ռ����� tempfile ·�� size ��;                                    
                  
               
              �޸Ĵ�С��
               alter tablespace  �ռ����� add datafile     ·�� size ��;
               
               Ĭ��ָ����alter database default tablespace   �ռ�����;
               
          ɾ����
               drop tablespace �ռ�����;  �߼�ɾ�� ��ռ�
               
               drop tablespace �ռ����� including contents; �߼�ɾ�� ��ռ� �� ��
               
               drop tablespace �ռ����� including contents and datafiles; �߼�ɾ�� ��ռ� �� �� ��������
               
         3.�û�����      
           �����û���
               create user  �û� identified  by ���� [default tablespace �ռ�����][temporary tablespace ��ʱ��ռ�]
               
               ��ѯ �û� �����ı�ռ䣺
                  select * from dba_users where username='��д�û���';    
                  
                  select * from dba_users where username='SYSTEM';   
               ɾ��:
               DROP USER �û���;           
               
               
           
           ��ɫ�����������Ȩ�޵�һ������
               ϵͳ ��ɫ��.........
               
               �Զ��� ��ɫ��
                   ������create role ��ɫ��
                   ����ɫ��Ȩ��grant Ȩ�� to ��ɫ��
                   ���û������ɫ��grant ��ɫ�� to �û���;
                   ɾ����ɫ��drop role ��ɫ��;
                   
                   
                   
      ��ϰ��
           1.������ռ� + ��ʱ��ռ�
           2.���û� ָ��Ҫ��ռ� 
           
           3.�鿴�û������ĸ���ռ�
           4.������ �û����� ѧ���� ��Ʒ��������
           
           5.��ע�� д���� .......
           6.д���� ͬ��� ��ͼ ����......
           
           7.�޸� ���� �޸�����.......
           
              
        -- ������ռ�
        create tablespace testSpace datafile 'd:\test.dbf' size 10M;
        create temporary tablespace tempTestSpace tempfile 'd:\tempTest.dbf' size 5M;       
        
        -- �޸Ĵ�С
        
        -- ɾ������
        
        
        -- �����û�
        create user testUser identified by 123456 
               default tablespace testSpace 
               temporary tablespace tempTestSpace;
        
        
        -- ��ѯ �û����ڵı�ռ�
        select * from  dba_users where username='TESTUSER';
        
        
        -- ��Ȩ��
        grant dba to testUser with admin option;
        
        
        drop table studentInfo;
        
        -- ���������
        create table studentInfo(
               id number(10) primary key not null,
               name varchar2(30)  not null,  -- unique
               password varchar2(100) not null,
               sex char(2) check(sex='��' or sex='Ů') not null,
               age number (3) not null,
               birthday date,
               address varchar2(200)
        );
        
        show user;
        
        -- ��ӱ�ע��
        comment on table studentInfo is 'ѧ����Ϣ��';
        
        -- �ֶ�ע��
        comment on column studentInfo.id is '���� Id';
        comment on column studentInfo.name is 'ѧ������';
        comment on column studentInfo.age is 'ѧ�� ����';
        
        -- ��������
        insert into studentInfo values (seq_sid.nextval,'��С��','123456879','��',20,date'2019-10-25','�����С���������');
        insert into studentInfo values (seq_sid.nextval,'���»�','123ABC9','��',66,date'2019-10-25','�����С���������222');
        
        -- ���� û�ύ
        commit;
        
        select * from studentInfo;
        seq_sid.nextval,seq_sid.nextval,
        
        
        -- ͬ��ʣ� ����ѯ��ʵ��ȡһ������
        create or replace synonym stio for studentInfo;

        select * from stio;
        
        
        -- ��ͼ����
        create  or replace view v_stu_info
                as
                -- ��ѯ SQL���
                select * from studentInfo;
       select * from  v_stu_info
        
       -- ��������
       create index i_stu_sex on studentInfo(sex);
       
       select * from studentInfo where sex ='��';
       
       -- ���в���
       create sequence seq_sid
       start with 3
       increment by 1
       minvalue 3
       
       
       -- �������
       insert into studentInfo values (seq_sid.nextval,'jiangxiaobia','123456879','Ů',20,sysdate,'CQ_GXQ');
       commit;
        
       
       ��������
             Oracle�е� ��������
             
             ͬ���
             
             ��ͼ��ʹ��
             
             ������ʹ��
              
             ���е�ʹ�� 
             
             
             ���� ���� ������.....
             
             
            1. Oracle�е� �������� 
             number(m,[n]) ��������
                    m:���ָ��� 38λ
                    n��С��
                    
                    number(5) :��Χ -99999 ~~~99999
                    number(5,1) ��Χ��-9999.9 ~~~9999.9
                    
             integer ��������
             char �̶��ַ��������� ���255���ַ�
             varchar2() �ɱ��ַ� 4000
             long: �ַ����ͣ����2G
             lob: ���������ͣ� 4G
             date:ʱ������
             
             ͬ��ʵ�ʹ�ã�
                 ��ʵ��ȡ������Ϊ ˽��/���� 
                 
                 ������create ��or replace�� [public] synonym ���� for ����
                 ɾ����drop [public] synonym ���� ;
                 
                 
             ��ͼ��ʹ��
                 ������create [or replace] view ��ͼ���� as ��ѯ��sql���;
                 ʹ�ã�select * [�ֶ�] from ��ͼ���� ������ѯ  ������� ���� ͳ�� ......
                 ɾ����drop view  ��ͼ����;
                 
             ����������
                 ������create index �������� on ����(�ֶ�)
                 ɾ����drop index ��������; 
                 
                 
             ���е�ʹ��
                 sql ���� ͨ�����Զ�����������Ҫ�ֶ��ṩ���ֶε�ֵ
                 
                 �������� ��ʽ��
                       create sequence sql_��������
                              start with ��ʼֵ
                              increment by ����
                              minvalue ��Сֵ
                              maxvalue ���ֵ
                              cycle ����ﵽ���ֵ�����¿�ʼ| nocycle (Ĭ��)�����¿�ʼ
                              cache ֵ ����������Ĭ��Ϊ20��| nocache (û�л���)
                              
                              
                 ɾ�����У�drop sequence ��������;
                 
                 
                 --- �Լ� ʹ��
                 
                 Oracle �еĺ��� ��ϵͳ����  �Զ��� ����
                 
                  1 �ַ�������
                    lower(n)
                    upper(n)
                    ltrim(n)
                    rtrim(n)
                    length(n)  
                    replace(m,n,k) ��m�е�k �滻Ϊk
                    .............
                  
                  2 ��ѧ����
                    abs()
                    ceil(n) ȡ ���ڵ���n����С����
                    
                    floor(n) С�ڵ���n����С����
                    round(n,m) ��������
                    trunc(n,m) ��n���н�ȡ m������
                    .....
                     
                  
                  
                  3 ת������
                    to_number(n,m) ���ַ�n���� m �ĸ�ʽת��Ϊ�������ͣ�
                    eg:'45218.45565698', 000.00
                    
                    to_char(n,m) 
                    
                    to_date(n,m)
                  
                    nvl(n,m) :��Ŀ����
                    
                    nvl2(n,m,k):
                    
                    
                  .......
                 
                oracle�еĲ�ѯ������
                  ....................
                           
                  
                  
               oracle�е��������
                  �����Ǳ�֤���ݿ��� ���ݵ�һ���ԣ�Ҫôȫ���ɹ� Ҫ��ȫ��ʧ�ܣ�
                  
                  �ύ����:commit;
                  �ع����rollback;
                  ���ñ����: set savepoint  ����;
                  �ع�������㣺rollback to ���ƣ�
                  
              oracle �еĴ洢���̣�
                    �洢���̣������� �����еķ��� ���ڷ�װһЩ����ҵ���߼���ִ��SQL��䣻
                    
                    
                    ��ʽ�������洢����
                    create or replace procedure pro_��������(����1 [ģʽ] ��������,
                                                             ����2 [ģʽ] ��������....)   
                       is/as
                          �������������
                                                                
                       begin
                          sql �������
                                                                    
                       end;
                              
                  ģʽ������/�������   in ����  out ��� Ĭ��Ϊ in   
                  
                  
                  ���÷�ʽ��
                       declare 
                            �������;
                           begin
                               ���ù���
                             end;        
                              
                              
                              
                oracle �еĺ���
                       ���� �û�oracle�еĹ������ƣ�
                       create or replace function fun_��������(������ ��������,......)
                              return ����ֵ����;
                              is/as
                                     �������������
                              begin
                                 sql�������
                                 return �Ż�ֵ;
                                end;
                                
                                
                      ���ã�
                      select fun_��������(�����б�) from dual; dual��oracle�е�Ĭ��վλ��ʶ��;          
                           
                      
      ����ʵ�֣�====>
            select * from studentInfo;  
            -- �ַ�������
            select lower('Java_123CLASS') as Сд from dual;    
            select upper('Java_123CLASS') as ��д from dual;   
                           
            
           select ltrim('    Java_123CLASS   ') as ȥ����߿ո� from dual;   
                            
           select length('    Java_123CLASS   ') as ���� from dual;   
                    
           select ltrim(rtrim('    Java_123CLASS   ')) as ȥ���ո� from dual;            
        
           select replace('С��','��','����') from dual;
       
       
      
         select * from scott.emp;    
         select lower(ename) as Сд from scott.emp;    
         
         -- �ַ��� ƴ��
         concat(str1,str2,str3....)
         
         select concat('����','һ��') as ƴ���ַ��� from dual;    
         
         -- ��ѧ����....
         select ceil(3.12) from dual;
         
         select floor(3.12) from dual;
         
         -- ת������
         select to_number('3.1415') from dual;
         
         select to_char(sysdate,'yyyy-MM-dd HH:mm:ss') from dual; 
         select to_date('20-01-09','yyyy/MM/dd') from dual;
         
         nvl2()
         
         
         select * from scott.emp;   
         select * from scott.dept;
         update scott.emp set comm= nvl2(comm,comm+100,300);
         
         
         oracle �еĳ���SQL���� ������SQL��� ����
         
         1. ���� ÿ���˵���н
         select empno ename, sal*12+nvl(comm,0) from scott.emp;
         
         2.�����µ�����Ա��
         select * from scott.emp t1
            inner join scott.dept t2
            on  t1.deptno = t2.deptno where t2.dname='SALES'; 
            
            
         select * from scott.emp where  deptno in (
                select deptno from scott.dept where dname='SALES'
         );
         
         ..................................
         
         
         -- ���� ����
         
            -- ��������
        insert into studentInfo values (seq_sid.nextval,'����Ӣ','123456879','Ů',30,date'1989-10-25','̨��');
        savepoint a;
        insert into studentInfo values (seq_sid.nextval,'���ǳ�','123ABC9','��',66,date'1899-10-25','���');
       
      
        savepoint b;
        insert into studentInfo values (seq_sid.nextval,'�ŷ�','123ABC9','��',66,date'1899-10-25','���');
        -- ���� û�ύ
        -- �ع�
        rollback to b;
        -- rollback;
        commit;
         
        select * from studentInfo;
         
        
       -- �Զ���:���� ����
       create or replace procedure pro_out_time
       is
       begin
         --���
         dbms_output.put_line('��ǰʱ��Ϊ:'||to_char(sysdate,'yyyy-MM-dd'));
         end;
         
         
         --���� 
         begin 
           pro_out_time;
           end;
        
          
         -- �������� 
         -- SELECT * FROM USER_ERRORS WHERE NAME='�洢��������'
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
                -- ��Ӳ���
                insert into scott.emp(empno,ename,sal)values(id,name,gz);  
                commit;
           end;
         
        -- ��Ȩ��
        grant dba to testUser with admin option;
        
        --  ����
        declare
            id number;
            name varchar(20);
            gz number;
            
            begin
              id:=51;
              name:='С��';
              gz:=9000;
              --����
              pro_insert_emp(id,name,gz);
            end;
            
            
            
          
        
        -- ���÷�ʽ��
        begin 
            pro_insert_emp(52,'С��',8596);
        end;
                 
       -- ���� ��ʽ��
        begin 
            pro_insert_emp(id=>53,name=>'С��',gz=>8596);
        end;             
     
   
        --���� ��ʽ��
        create or replace procedure pro_insert_emp_1
        (
               id emp.empno%type,
               name emp.ename%type,
               gz emp.sal%type
               
        )
        is
        begin
           -- ��Ӳ���
           insert into scott.emp(empno,ename,sal)values(id,name,gz);  
           commit;
        end;
        
        -- ���÷�ʽ
        declare
           id number:=54;
           name varchar2(20):='С��';
           gz number:=8001;
        begin
           pro_insert_emp_1(id,name,gz);
        end;   
        
           
       -- ����������û��� ��ѯ ��� �͹���
       create or replace procedure pro_select_emp(
              name emp.ename%type, id out number,gz out number
       )    
       is
       begin
          -- ��ѯ
          select  empno,sal into id,gz from emp where ename=name;
       end;
        
       
       --����
       declare 
          name varchar2(20):='С��';
          id number;
          gz number;
          
          begin
             pro_select_emp(name,id,gz);
             
             -- ���
             dbms_output.put_line('���Ϊ��'||id);
             dbms_output.put_line('����Ϊ��'||gz);
          end;
       
        
        
       select * from emp;     
                   
               
                     
                 
               
                          
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
  
                               
                        
                        
                        
                       
                         
    
    


