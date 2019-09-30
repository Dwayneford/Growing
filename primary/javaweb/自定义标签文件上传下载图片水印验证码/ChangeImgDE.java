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
	 * 图片水印
	 *  将需要 改变的图片 读入程序中
	 *  确定需要添加的水印内容
	 *  获取 画布 画笔 开始水印的制作
	 *  将水印图片 保存
	 */
	public void updateImg(HttpServletRequest req, HttpServletResponse res){
		// 获取图片
		String mainImg = req.getServletContext().getRealPath("/uploadFile/apple_1.jpg");
		String logoImg = req.getServletContext().getRealPath("/uploadFile/logo.jpg");
		//转换为图片
		ImageIcon main_icon = new ImageIcon(mainImg);
		ImageIcon logo_icon = new ImageIcon(logoImg);
		//创建 画布 
		BufferedImage buf_img = new BufferedImage(main_icon.getIconWidth(), main_icon.getIconHeight(),
				BufferedImage.TYPE_3BYTE_BGR);
		//获得 画笔
		Graphics  g = buf_img.getGraphics();
		//绘制图片
		g.drawImage(main_icon.getImage(), 0, 0, null);
		g.drawImage(logo_icon.getImage(), 100, 100, null);
		
		//将绘制的内容 赋值给主图
		g.setColor(Color.yellow);
		g.setFont(new Font("楷体", Font.BOLD, 22));
		g.drawString("http://www.taobao.com", 20, 150);
		//存放 到自定位置
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
	 * 验证码功能实现
	 */
	public void getCode(HttpServletRequest req, HttpServletResponse res){
		
		//获取底图片
		ImageIcon rd_img=new ImageIcon(req.getServletContext().getRealPath("/uploadFile/codeBase.png"));
		//获得画布
		BufferedImage bi = new BufferedImage(rd_img.getIconWidth(), rd_img.getIconHeight(), BufferedImage.TYPE_3BYTE_BGR);
		//画笔
		Graphics gs = bi.getGraphics();
		
		//开始绘制内容
		gs.drawImage(rd_img.getImage(), 0, 0, null);
		
		//设置验证吗内容
		String str ="ow2iajrjqlpeogf234k2jwst5po34234l5kkj3l45j23j455";
		
		//选取 生成验证吗
		Random rd = new Random();
		
		//存放随机数据
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < 4; i++) {
			sb.append(str.charAt(rd.nextInt(str.length())));
		}
		
		//将验证 吗 存入sesssion中、
		HttpSession session = req.getSession();
		Long rgTime = System.currentTimeMillis();
		CodeEnt ce = new CodeEnt(sb.toString(),rgTime+(30*1000));
		
		session.setAttribute("codeEnt", ce);
		
		//给验证吗 添加 干扰 数据
		gs.setColor(Color.green);
		gs.setFont(new Font("宋体", Font.ITALIC, 40));
		gs.drawString(sb.toString(), 70, 60);
		
		
		//产生 随机线在图片上
		for (int i = 0; i < 10; i++) {
			gs.setColor(Color.red);
			
			//确定坐标点
			int x1 = rd.nextInt(rd_img.getIconWidth());
			int y1 = rd.nextInt(rd_img.getIconHeight());
			int x2 = rd.nextInt(rd_img.getIconWidth());
			int y2 = rd.nextInt(rd_img.getIconHeight());
			
			//画线
			gs.drawLine(x1, y1, x2, y2);
		}

		//干扰点
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 2, 3);
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 10, 7);
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 4, 9);
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 12, 13);
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 15, 16);
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 8, 9);
		gs.drawOval(rd.nextInt(rd_img.getIconWidth()), rd.nextInt(rd_img.getIconHeight()), 5, 7);
		
		//输出到客户端
		try {
			ImageIO.write(bi, "png", res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
