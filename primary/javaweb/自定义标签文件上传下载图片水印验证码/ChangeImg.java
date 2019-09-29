package com.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

import com.entity.CodeEnt;



public class ChangeImg extends HttpServlet {
	
	//get����Ĵ�����
	public void doGet(HttpServletRequest requset,HttpServletResponse response)throws ServletException,IOException{
		doPost(requset, response);
	}
	
	//post����Ĵ�����
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//�����ʽ����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//ͨ�������ж�ִ�кη���
		String op = request.getParameter("op");
		if (("updateImg").equals(op)) {
			//�������ˮӡ����
			updateImg(request, response);
		}else if (("getCode").equals(op)) {
			//���û�ȡ��֤�뷽��
			getCode(request, response);
		}else if (("queryWebsiteByName").equals(op)) {
			test(request, response);
		}else if (("update").equals(op)) {
			test(request, response);
		}else if (("delete").equals(op)) {
			test(request, response);
		}else if (("queryWebsiteByNamelayout").equals(op)) {
			test(request, response);
		}else if (("query").equals(op)) {
			test(request, response);
		}
		

				
	}
	
	
	private void test(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			
		}

	/**
	 * ͼƬˮӡ
	 *  ����Ҫ �ı��ͼƬ ���������
	 *  ȷ����Ҫ��ӵ�ˮӡ����
	 *  ��ȡ ���� ���� ��ʼˮӡ������
	 *  ��ˮӡͼƬ ����
	 */		
	public void updateImg(HttpServletRequest req, HttpServletResponse res){
		// ��ȡͼƬ
		String mainImg = req.getServletContext().getRealPath("/upload/mainimg.jpg");
		String logoImg = req.getServletContext().getRealPath("/upload/logo.jpg");
		//ת��ΪͼƬ
		ImageIcon main_icon = new ImageIcon(mainImg);
		ImageIcon logo_icon = new ImageIcon(logoImg);
		//���� ���� 
		BufferedImage buf_img = new BufferedImage(main_icon.getIconWidth(), main_icon.getIconHeight(), BufferedImage.TYPE_3BYTE_BGR);
		//��� ����
		Graphics  g = buf_img.getGraphics();
		//����ͼƬ
		g.drawImage(main_icon.getImage(), 0, 0, null);
		g.drawImage(logo_icon.getImage(), 100, 100, null);
		
		//�����Ƶ����� ��ֵ����ͼ
		g.setColor(Color.yellow);
		g.setFont(new Font("����", Font.BOLD, 22));
		g.drawString("http://www.taobao.com", 20, 150);
		//��� ���Զ�λ��
		String saveUrl = req.getServletContext().getRealPath("/upload");
		
		try {
			/*ImageIO.write(buf_img, "jpg", res.getOutputStream());
			ImageIO.write(buf_img, "jpg", new File("d:/main_logo.jpg"));*/
			ImageIO.write(buf_img, "jpg", new File(saveUrl+"/main_logo.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
//ͼƬˮӡ:<div><img alt="" src="servlet/ChangeImg?op=updateImg"></div>	


	//��֤�빦��ʵ��
	public void getCode(HttpServletRequest req, HttpServletResponse res){
		//��ȡ��ͼƬ
		ImageIcon rd_img = new ImageIcon(req.getServletContext().getRealPath("/upload/codeimg.jpg"));
		//��û���
		BufferedImage bi = new BufferedImage(rd_img.getIconWidth(), rd_img.getIconHeight(), BufferedImage.TYPE_3BYTE_BGR);
		//����
		Graphics gs = bi.getGraphics();
		//��ʼ��������
		gs.drawImage(rd_img.getImage(), 0, 0, null);
		//������֤������
		String str = "qwerrtuipdfhvcx124578933ASFGBZATJLIOPZVCXASQWE";
		//ѡȡ������֤��
		Random rd = new Random();
		//����������
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			sb.append(str.charAt(rd.nextInt(str.length())));
		}
		//��֤�����session��
		HttpSession session = req.getSession();
		long rgTime = System.currentTimeMillis();
		CodeEnt ce = new CodeEnt(sb.toString(), rgTime+(30*1000));
		session.setAttribute("CodeEnt", ce);
		//����֤��������
		gs.setColor(Color.green);
		gs.setFont(new Font("����",Font.ITALIC,40));
		gs.drawString(sb.toString(), 40, 30);
		//�����������ͼƬ��
		for (int i = 0; i < 5; i++) {
			gs.setColor(Color.red);
			//ȷ�������
			int x1 = rd.nextInt(rd_img.getIconWidth());
			int y1 = rd.nextInt(rd_img.getIconHeight());
			int x2 = rd.nextInt(rd_img.getIconWidth());
			int y2 = rd.nextInt(rd_img.getIconHeight());
			
			//����
			gs.drawLine(x1, y1, x2, y2);
		}
		//���ŵ�
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 8, 36);
		
		//������ͻ���
		try {
			ImageIO.write(bi, "jpg", res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
//	��֤��:<img alt="" onclick="changeCode(this)"  src="servlet/ChangeImg?op=getCode">
//	<br>
//	<script type="text/javascript">
//		//����л�ͼƬ����
//		function changeCode(img){
//		img.src=img.src+"&"+new Date().getTime();
//		}
//
//	</script>	
	
}
