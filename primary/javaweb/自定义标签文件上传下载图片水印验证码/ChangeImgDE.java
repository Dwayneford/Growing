package com.jjfk.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

import com.jjfk.entity.CodeEnt;
import com.jjfk.util.BaseServlet;

public class ChangeImg extends BaseServlet {
	/**
	 * ͼƬˮӡ
	 *  ����Ҫ �ı��ͼƬ ���������
	 *  ȷ����Ҫ��ӵ�ˮӡ����
	 *  ��ȡ ���� ���� ��ʼˮӡ������
	 *  ��ˮӡͼƬ ����
	 */
	public void updateImg(HttpServletRequest req, HttpServletResponse res){
		// ��ȡͼƬ
		String mainImg = req.getServletContext().getRealPath("/uploadFile/apple_1.jpg");
		String logoImg = req.getServletContext().getRealPath("/uploadFile/logo.jpg");
		//ת��ΪͼƬ
		ImageIcon main_icon = new ImageIcon(mainImg);
		ImageIcon logo_icon = new ImageIcon(logoImg);
		//���� ���� 
		BufferedImage buf_img = new BufferedImage(main_icon.getIconWidth(), main_icon.getIconHeight(),
				BufferedImage.TYPE_3BYTE_BGR);
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
		String saveUrl = req.getServletContext().getRealPath("/uploadFile");
		
		try {
			/*ImageIO.write(buf_img, "jpg", res.getOutputStream());
			ImageIO.write(buf_img, "jpg", new File("d:/main_logo.jpg"));*/
			ImageIO.write(buf_img, "jpg", new File(saveUrl+"/main_logo.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ��֤�빦��ʵ��
	 */
	public void getCode(HttpServletRequest req, HttpServletResponse res){
		
		//��ȡ��ͼƬ
		ImageIcon rd_img=new ImageIcon(req.getServletContext().getRealPath("/uploadFile/codeBase.png"));
		//��û���
		BufferedImage bi = new BufferedImage(rd_img.getIconWidth(), rd_img.getIconHeight(), BufferedImage.TYPE_3BYTE_BGR);
		//����
		Graphics gs = bi.getGraphics();
		
		//��ʼ��������
		gs.drawImage(rd_img.getImage(), 0, 0, null);
		
		//������֤������
		String str ="ow2iajrjqlpeogf234k2jwst5po34234l5kkj3l45j23j455";
		
		//ѡȡ ������֤��
		Random rd = new Random();
		
		//����������
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < 4; i++) {
			sb.append(str.charAt(rd.nextInt(str.length())));
		}
		
		//����֤ �� ����sesssion�С�
		HttpSession session = req.getSession();
		Long rgTime = System.currentTimeMillis();
		CodeEnt ce = new CodeEnt(sb.toString(),rgTime+(30*1000));
		
		session.setAttribute("codeEnt", ce);
		
		//����֤�� ��� ���� ����
		gs.setColor(Color.green);
		gs.setFont(new Font("����", Font.ITALIC, 40));
		gs.drawString(sb.toString(), 70, 60);
		
		
		//���� �������ͼƬ��
		for (int i = 0; i < 10; i++) {
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
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 2, 3);
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 10, 7);
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 4, 9);
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 12, 13);
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 15, 16);
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 8, 9);
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 5, 7);
		
		//������ͻ���
		try {
			ImageIO.write(bi, "png", res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
