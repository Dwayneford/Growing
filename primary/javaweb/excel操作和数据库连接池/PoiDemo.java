package com.jjfk.exceldemo;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jjfk.dao.IGoods;
import com.jjfk.dao.impl.GoodsImpl;
import com.jjfk.entity.Goods_table;

public class PoiDemo {
	/*1. poi 是Apache软件基金会 开源式 函数库，专门针对 微软软件的读写操作；
	  2. 提供的类？ 作用？
		 HSSF:提供读写 excel格式的档案功能
		 XSSF:提供读写 excel OOXML格式的档案功能
		 HWPF:提供读写 Mricrososft Word格式的档案功能
		 HSLF:提供读写 Mricrososft PowerPoint格式的档案功能
		 HDGF:提供读写 Mricrososft Visio格式的档案功能
	   
	   3.需要映入的包：	 poi poi-OOXML .....
	   
	   4.HSSF功能概述
	   		HSSFWorkbook  excel文档创建
	   		HSSFSheet excel的sheet
	   		HSSFRow 
	   		HSSFCell
	   		HSSFFont
	   		
	   		HSSFName
	   		HSSFDateFormat 日期格式
	   		HSSFHead sheet头部
	   		HSSFFooter 尾部
	   		HSSF.....
	   		HSSF.....
		 */
	/**
	 * poi操作excel
	 * @throws UnsupportedEncodingException 
	 * 	
	 */
	public void exportExcel() throws UnsupportedEncodingException{
		//模拟 数据库查询数据
		IGoods goodDao = new GoodsImpl();
		List<Goods_table> list = goodDao.queryGoods(null, 0.00);
		
		//创建工作簿对象
		HSSFWorkbook wb = new HSSFWorkbook();
		
		//标题样式
		
		
		//创建内容样式
		
		
		//创建工作表
		HSSFSheet sheet_1 = wb.createSheet("商品信息表");
		sheet_1.setDefaultColumnWidth(30);
		
		//创建标题
		HSSFRow headRow = sheet_1.createRow(0);
		//创建标题行的第一列
		HSSFCell head_cell_1 = headRow.createCell(0);
		head_cell_1.setCellValue("商品ID");
		//head_cell_1.setCellStyle(headStyle);
		HSSFCell head_cell_2 = headRow.createCell(1);
		head_cell_1.setCellValue("商品名称");
		//head_cell_1.setCellStyle(headStyle);
		HSSFCell head_cell_3 = headRow.createCell(2);
		head_cell_1.setCellValue("商品数量");
		//head_cell_1.setCellStyle(headStyle);
		HSSFCell head_cell_4 = headRow.createCell(3);
		head_cell_1.setCellValue("商品类型");
		//head_cell_1.setCellStyle(headStyle);
		HSSFCell head_cell_5 = headRow.createCell(4);
		head_cell_1.setCellValue("商品价格");
		//head_cell_1.setCellStyle(headStyle);
		HSSFCell head_cell_6 = headRow.createCell(5);
		head_cell_1.setCellValue("商品日期");
		//head_cell_1.setCellStyle(headStyle);
		HSSFCell head_cell_7 = headRow.createCell(6);
		head_cell_1.setCellValue("有效日期");
		//head_cell_1.setCellStyle(headStyle);
		
		//给头部下面的行添加内容
		for (int i = 1; i <= list.size(); i++) {
			//操作的行
			HSSFRow contentRow = sheet_1.createRow(i);
			//操作的列
			HSSFCell content_cess_1 = contentRow.createCell(0);
			content_cess_1.setCellValue(list.get(i-1).getGood_id());
			//设置样式.....
			
			HSSFCell content_cess_2 = contentRow.createCell(1);
			content_cess_2.setCellValue(list.get(i-1).getGood_id());
			//设置样式.....
			HSSFCell content_cess_3 = contentRow.createCell(2);
			content_cess_3.setCellValue(list.get(i-1).getGood_id());
			//设置样式.....
			HSSFCell content_cess_4 = contentRow.createCell(3);
			content_cess_4.setCellValue(list.get(i-1).getGood_id());
			//设置样式.....
			HSSFCell content_cess_5 = contentRow.createCell(4);
			content_cess_5.setCellValue(list.get(i-1).getGood_id());
			//设置样式.....
			HSSFCell content_cess_6 = contentRow.createCell(5);
			content_cess_6.setCellValue(list.get(i-1).getGood_id());
			//设置样式.....
			HSSFCell content_cess_7 = contentRow.createCell(6);
			content_cess_7.setCellValue(list.get(i-1).getGood_id());
			//设置样式.....
		}
		
		//通过浏览器 下载到客户端
		String fileName = new String("goodsInfo.xls".getBytes("utf-8"), "ISO-8859-1");
		
		//响应
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
