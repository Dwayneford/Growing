-- 创建过程/函数	查询表中的数据 所有
create PROCEDURE queryAll()
BEGIN 
	SELECT * FROM employeefw;

end;

call queryAll()
-- 创建过程/函数	传递参数 通过id查询 名称字段
create PROCEDURE queryByID(in idnum int) 
BEGIN 
	SELECT name FROM employeefw e WHERE e.id=idnum;

end;

call queryByID(5)

-- 定义过程，在过程中定义变量id name age 给变量赋值 输出 赋值后的变量

CREATE PROCEDURE DefinitionAndOutput()
BEGIN 
	
	INSERT INTO  employeeFW (ID,name,age) VALUES(10,'admin',20);
	SELECT * FROM employeefw WHERE employeefw.name = 'nameStr';
end;

CALL DefinitionAndOutput;

/*
INSERT INTO  employeeFW (null,name,age) VALUES(null,'nameStr',25);
SELECT * FROM employeefw WHERE employeefw.name = '王五';
(in idNum int , in nameStr VARCHAR , in ageNum int)

*/

-- 过程 如果年龄在20以下的工资加200，20到25的加400，25以上的加1000 ：使用 if 或者 case条件判断操作


CREATE PROCEDURE ifcaseadd ( in idnum int)
BEGIN
	DECLARE uage int;	
	SELECT age into uage FROM employeefw WHERE id= idnum;

	if uage < 20 then
			UPDATE employeefw set salary = salary+200 WHERE id = idnum;
	ELSEIF 	uage >=20 and uage <25 THEN
			UPDATE employeefw set salary = salary+400 WHERE id = idnum;
	ELSE 
			UPDATE employeefw set salary = salary+1000 WHERE id = idnum;
	end if;

 END;

call ifcaseadd(3)
SELECT *FROM employeefw

-- 使用while循环  插入指定条数据；

CREATE PROCEDURE pro_while(in num int)
BEGIN 
	while num>0 DO
		INSERT into employeefw VALUES ('莱恩',99,'男',21000,'西永大道',null);
			set num=num-1 ;
	end WHILE;


end;

call pro_while (13);
SELECT * FROM employeefw









