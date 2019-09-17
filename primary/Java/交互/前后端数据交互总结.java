package summary;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.getwebsiteinfo.dao.IWebsites;
import com.getwebsiteinfo.dao.impl.WebsitesImpl;
import com.getwebsiteinfo.entity.Websites;
import com.getwebsiteinfo.util.JDBCUtil;

public class summary {

}
/**
前后端数据交互：
使用MySQL，java，jsp实现数据交互
一、java代码：
总目录（包）：com
1、实体层：entity
	存放实体类对象，包含私有的属性，set和get方法，多个有参无参构造器，toString方法。
2、dao层：dao和实现类implement	
	对数据库增删改查的接口和实现类方法
	//例子 a、数据库连接对象connection，sql语句预编译对象PreparedStatement，执行execute方法，得到结果集resultSet
	//查询方法，返回结果集和
	public ArrayList<Websites> queryWebsites() {		
		Connection conn = null;			//首先定义此方法将要用到的对象
		PreparedStatement ps = null;	//sql语句预编译对象
		ResultSet rs = null;			//结果集对象
		ArrayList<Websites> list = new ArrayList<Websites>();	//存放返回的网站对象
		String sql = "select * from websites"; 		//sql查询语句
		
		//连接数据库，查询数据；创建一个JDBCUtil类的对象conn
		conn = new JDBCUtil().getConn();
		//用此连接对象的方法将sql语句预编译,得到一个预编译对象ps
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("预编译sql语句失败！");
			e.printStackTrace();
		}
		//预编译完成后，执行sql语句,得到结果集rs
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("查询失败!");
			e.printStackTrace();
		}
		//遍历并封装结果集
		try {
			while (rs.next()) {
				Websites ws = new Websites(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("url"), 
						rs.getString("alexa"), 
						rs.getString("country"));
				list.add(ws);
			}
		} catch (SQLException e) {
			System.out.println("遍历并封装结果集错误");
			e.printStackTrace();
		}
		return list;
	}
3、servlet控制器
	接收前端参数，根据参数调用dao层方法
		doPost方法：
		//编码格式设置
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//接收参数
		String parm = request.getParameter("method");
		if (("queryWebsitesList").equals(parm)) {
			//调用列表查询方法
			queryWebsitesList方法:
		//调用dao层方法获取列表数据
		IWebsites iWebsites = new WebsitesImpl();
		//返回的数据retList
		List<Websites> retList = iWebsites.queryWebsites();		
		//拼接成 layUI需要的格式数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 200);
		map.put("data", retList);
		//将返回的数据转为json格式数据
		String jsonWebsites = gs.toJson(retList);
		//向客户端输出
		PrintWriter out = response.getWriter();
		out.print(jsonWebsites);
		//刷新关闭
		out.flush();
		out.close();
4、数据库连接工具类

5、前端页面
form表单存取数据，
ajax表单url: 'websitesServletUrl?method=queryWebsitesList', //请求数据的URL 参数附后
参数序列化var formData = $("#from1").serialize();
$.post('websitesServletUrl?op=save',formData,function(){
	//列表数据 刷新
	$("#dg").datagrid("reload");
});





*/