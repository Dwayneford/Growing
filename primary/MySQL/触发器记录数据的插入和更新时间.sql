-- 新建表
CREATE table caragory(
id int (11) not null primary key auto_increment,
name VARCHAR(255) DEFAULT null ,
create_time datetime DEFAULT null,
update_time datetime DEFAULT null
)

-- 创建触发器create_time 记录插入时间
drop TRIGGER create_time 

create TRIGGER create_time before insert on caragory for each row 
begin 
set new.create_time = now();

end;

create TRIGGER update_time before update on caragory for each row 
begin 

set new.update_time = now();
end;


INSERT into caragory(id,name,create_time,update_time)  VALUE(null,null,null,null);


INSERT into caragory values (null,'gfdh',null,null),(188,'opiod',null,null);	

SELECT * from caragory



