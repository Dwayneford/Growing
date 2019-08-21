

//案列，求和的存储过程
	-- 创建
	CREATE PROCEDURE pro_sum11(in a int , in b int , out sum int )
		BEGIN 
			-- 执行运算操作
			SELECT (a+b) into sum;


		end;
	-- 调用
	set @a = 65;
	set @b = 23;
	call pro_sum11(@a , @b, @sum);
	
	-- 取值
	SELECT @sum;
	-- 删除
	DROP PROCEDURE pro_sum;
	//方式二
 -- 创建
	CREATE PROCEDURE pro_sum123(in a int , in b int , out sum int)
		BEGIN 
			if 
				a is null then set a =0; 
			end if;

			if 
				b is null then set b =0; 
			end if;

			set sum =a+b;
		end;

	call pro_sum123(45,36,@sum);
	SELECT @sum;


//函数 returnS ！！后面有一个S！
create FUNCTION fun_sum (a int , b int ) RETURNs int
BEGIN 
	-- 声明变量
	DECLARE sum int ;
	-- 运算块
	set sum= a+b ;
	-- 返回
	RETURN sum;
end;
-- 调用
SELECT fun_sum(56,485) as fun_sum;


