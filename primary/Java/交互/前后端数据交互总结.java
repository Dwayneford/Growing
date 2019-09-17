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
ǰ������ݽ�����
ʹ��MySQL��java��jspʵ�����ݽ���
һ��java���룺
��Ŀ¼��������com
1��ʵ��㣺entity
	���ʵ������󣬰���˽�е����ԣ�set��get����������в��޲ι�������toString������
2��dao�㣺dao��ʵ����implement	
	�����ݿ���ɾ�Ĳ�Ľӿں�ʵ���෽��
	//���� a�����ݿ����Ӷ���connection��sql���Ԥ�������PreparedStatement��ִ��execute�������õ������resultSet
	//��ѯ���������ؽ������
	public ArrayList<Websites> queryWebsites() {		
		Connection conn = null;			//���ȶ���˷�����Ҫ�õ��Ķ���
		PreparedStatement ps = null;	//sql���Ԥ�������
		ResultSet rs = null;			//���������
		ArrayList<Websites> list = new ArrayList<Websites>();	//��ŷ��ص���վ����
		String sql = "select * from websites"; 		//sql��ѯ���
		
		//�������ݿ⣬��ѯ���ݣ�����һ��JDBCUtil��Ķ���conn
		conn = new JDBCUtil().getConn();
		//�ô����Ӷ���ķ�����sql���Ԥ����,�õ�һ��Ԥ�������ps
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("Ԥ����sql���ʧ�ܣ�");
			e.printStackTrace();
		}
		//Ԥ������ɺ�ִ��sql���,�õ������rs
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("��ѯʧ��!");
			e.printStackTrace();
		}
		//��������װ�����
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
			System.out.println("��������װ���������");
			e.printStackTrace();
		}
		return list;
	}
3��servlet������
	����ǰ�˲��������ݲ�������dao�㷽��
		doPost������
		//�����ʽ����
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//���ղ���
		String parm = request.getParameter("method");
		if (("queryWebsitesList").equals(parm)) {
			//�����б��ѯ����
			queryWebsitesList����:
		//����dao�㷽����ȡ�б�����
		IWebsites iWebsites = new WebsitesImpl();
		//���ص�����retList
		List<Websites> retList = iWebsites.queryWebsites();		
		//ƴ�ӳ� layUI��Ҫ�ĸ�ʽ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 200);
		map.put("data", retList);
		//�����ص�����תΪjson��ʽ����
		String jsonWebsites = gs.toJson(retList);
		//��ͻ������
		PrintWriter out = response.getWriter();
		out.print(jsonWebsites);
		//ˢ�¹ر�
		out.flush();
		out.close();
4�����ݿ����ӹ�����

5��ǰ��ҳ��
form����ȡ���ݣ�
ajax��url: 'websitesServletUrl?method=queryWebsitesList', //�������ݵ�URL ��������
�������л�var formData = $("#from1").serialize();
$.post('websitesServletUrl?op=save',formData,function(){
	//�б����� ˢ��
	$("#dg").datagrid("reload");
});





*/