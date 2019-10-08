package com.jjfk.exceldemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.DateTime;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JxlDemo {
	
	
	/*操作excel的工具类：两种 jxl ，poi
	
	如何使用：两个工具包
		下载驱动jar包
			jxl-2.6.12.jar
			poi-3.17.jar
			poi-ooxml-3.15.jar
			poi-ooxml-schemas-3.15.jar
			
	操作excel的常用方法？
		//创建可写入的excel工作簿
		WritableWorkbook wwb =	Workbook.createWorkbook(new File("文件存放路径"));
		//写入到流中
		OutputStream os= new FileOutputStream("文件存放路径");
		
		//创建表
		WritableSheet ws = wwb.createSheet("表名称", 0);
		
		//单元格
		Label label = new Label(0, 0, "单元格内容");
		
		//设置单元格 样式
		WritableFont font =	new WritableFont(WritableFont.ARIAL,18,WritableFont.BOLD);
		
		// 单元格添加字段：字符串 时间  boolean数据 公式 图片 等等 内容
		//添加number
		Number lableN = new Number(0, 1, 3.1415296);
		ws.addCell(lableN);
		//时间操作
		DateTime lableDt = new DateTime(0, 2, new Date());
		ws.addCell(lableDt);
		//图片操作
		WritableImage wrimage =	new WritableImage(0, 5, 15, 15, new File("imgPath"));
		ws.addImage(wrimage);
		
		//公式
		Formula formulal=new Formula(0, 11, "Sum(A1:A9)");
		//........
		
		//合并单元格  从第x+1列  y+1行  到m+1列 n+1列合并
		ws.mergeCells(0, 0, 9, 0);
		
		
		读取Excel?
			//1. 选取excel文档
			Workbook workbook = Workbook.getWorkbook(new File("myfile.xls"));
			
			//2.读取 工作表
			Sheet sheet = workbook.getSheet(0);
			//3.读取内容
			Cell c2= sheet.getCell(2, 1);
			
			//4 取内容
			String string2 = c2.getContents();
			//可以通过 celltype 确定数据类型： DATE NUMBER....
			//5 释放资源
			workbook.close();
	*/
	/**
	 * 函数入口
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		JxlDemo jd = new JxlDemo();
		//jd.createExcel();
		//jd.inversExcel();
		jd.createFormtStud("d://sutInfoAll.xls");
	}
	/**
	 * 导出学生信息 excel数据
	 * @throws IOException 
	 */
	public void createFormtStud(String filePath) throws Exception{
		//导出文件位置
		File stuFile = new File(filePath);
		//获取工作簿
		WritableWorkbook  wwb = Workbook.createWorkbook(stuFile);
		
		//判断是否存在
		if(wwb!=null){
			//创建工作表
			WritableSheet ws = wwb.createSheet("导出的学习信息", 0);
			//设置标题行
			ws.mergeCells(0, 0, 9, 0);
			//设置头部内容
			String[] strs={"学号","姓名","性别","身份证","电话","籍贯","地址","亲友电话","联系人","入学时间"};
			//确定 excel表格需要的样式
			//字体格式1
			WritableFont font1 =new WritableFont(WritableFont.TAHOMA, 18, WritableFont.BOLD);
			//字体格式2
			WritableFont font2 =new WritableFont(WritableFont.ARIAL, 13, WritableFont.BOLD);
			
			//格式化单元格
			WritableCellFormat format1 = new WritableCellFormat(font1);
			WritableCellFormat format2 = new WritableCellFormat(font2);
			WritableCellFormat format3 = new WritableCellFormat();
			
			//设置内容居中
			format1.setAlignment(jxl.format.Alignment.CENTRE);
			//垂直对齐
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			//添加边框
			format1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			
			format2.setAlignment(jxl.format.Alignment.CENTRE);
			format2.setBackground(jxl.format.Colour.PINK);
			//自动换行
			format2.setWrap(true);
			
			format3.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			format3.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			format3.setAlignment(jxl.format.Alignment.CENTRE);
			
			//设置高度
			ws.setRowView(0, 700);
			
			//设置内容
			Label label = new Label(0, 0, "yc123班级学生信息表",format1);
			//添加
			ws.addCell(label);
			//设置列的宽度
			for (int i = 0; i < 10; i++) {
				Label lblc = new Label(i,1,strs[i],format2);
				
				if(i==0){
					//设置宽度
					ws.setColumnView(i, 10);
				}else if(i==3){
					ws.setColumnView(i, 29);
					
				}else if(i==4){
					ws.setColumnView(i, 38);
					
				}else if(i==6){
					ws.setColumnView(i, 18);
					
				}else if(i==7){
					ws.setColumnView(i, 15);
					
				}else{
					ws.setColumnView(i, 20);
				}
				//添加到单元格中
				ws.addCell(lblc);
			}
			
			//从数据库中取出数据 循环 生成到 excel中
			for (int i = 2; i < 22; i++) {
				
				for (int j = 0; j < 10; j++) {
					
					Label lab = new Label(j, i, "这是第"+(i+j)+"数据",format3);
					ws.addCell(lab);
				}
			}
			//写入文件
			wwb.write();
			wwb.close();
			System.out.println("===OK==");
		}
		
	}
	
	
	/**
	 * 导入excel
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public void inversExcel() throws BiffException, IOException{
		//获取文件
		File xlsFile = new File("d://studentInfo.xls");
		//获取工作簿对象
		Workbook workbook = Workbook.getWorkbook(xlsFile);
		//获取所有的工作表
		Sheet[] sheets = workbook.getSheets();
		//判断 是否为空
		if(sheets!=null){
			//遍历
			for (Sheet sheet : sheets) {
				//获取行
				int rows = sheet.getRows();
				//获取列
				int cols = sheet.getColumns();
				//读取数据
				for (int row = 0; row < rows; row++) {
					for (int col = 0; col < cols; col++) {
						//封装为对象
						System.out.printf("%10s",sheet.getCell(col, row).getContents());
					}
					System.out.println();
				}
			}
			
		}
		workbook.close();
	}
		
	/**
	 * 简单创建 excel 工作 簿
	 * @throws Exception 
	 */
	public void createExcel() throws Exception{
		File xlsFile = new File("d://studentInfo.xls");
		//创建 工作 簿
		WritableWorkbook workBook = Workbook.createWorkbook(xlsFile);
		//创建工作表
		WritableSheet sheet = workBook.createSheet("学生 信息表", 0);
		
		//取出数据库中的数据 存放到表中
		for(int row=0; row<10;row++){
			for (int col=0; col<10; col++) {
				//给单元格中 追加数据
				Label label = new Label(col, row, "stuInfo"+row+col);
				//存放到工作表格中
				sheet.addCell(label);
			}
		}
		
		//写 入  关闭
		workBook.write();
		workBook.close();
	}
	

}
