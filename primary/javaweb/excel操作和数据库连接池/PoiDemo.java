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
	/*1. poi ��Apache�������� ��Դʽ �����⣬ר����� ΢������Ķ�д������
	  2. �ṩ���ࣿ ���ã�
		 HSSF:�ṩ��д excel��ʽ�ĵ�������
		 XSSF:�ṩ��д excel OOXML��ʽ�ĵ�������
		 HWPF:�ṩ��д Mricrososft Word��ʽ�ĵ�������
		 HSLF:�ṩ��д Mricrososft PowerPoint��ʽ�ĵ�������
		 HDGF:�ṩ��д Mricrososft Visio��ʽ�ĵ�������
	   
	   3.��Ҫӳ��İ���	 poi poi-OOXML .....
	   
	   4.HSSF���ܸ���
	   		HSSFWorkbook  excel�ĵ�����
	   		HSSFSheet excel��sheet
	   		HSSFRow 
	   		HSSFCell
	   		HSSFFont
	   		
	   		HSSFName
	   		HSSFDateFormat ���ڸ�ʽ
	   		HSSFHead sheetͷ��
	   		HSSFFooter β��
	   		HSSF.....
	   		HSSF.....
		 */
	/**
	 * poi����excel
	 * @throws UnsupportedEncodingException 
	 * 	
	 */
	public void exportExcel() throws UnsupportedEncodingException{
		//ģ�� ���ݿ��ѯ����
		IGoods goodDao = new GoodsImpl();
		List<Goods_table> list = goodDao.queryGoods(null, 0.00);
		
		//��������������
		HSSFWorkbook wb = new HSSFWorkbook();
		
		//������ʽ
		
		
		//����������ʽ
		
		
		//����������
		HSSFSheet sheet_1 = wb.createSheet("��Ʒ��Ϣ��");
		sheet_1.setDefaultColumnWidth(30);
		
		//��������
		HSSFRow headRow = sheet_1.createRow(0);
		//���������еĵ�һ��
		HSSFCell head_cell_1 = headRow.createCell(0);
		head_cell_1.setCellValue("��ƷID");
		//head_cell_1.setCellStyle(headStyle);
		HSSFCell head_cell_2 = headRow.createCell(1);
		head_cell_1.setCellValue("��Ʒ����");
		//head_cell_1.setCellStyle(headStyle);
		HSSFCell head_cell_3 = headRow.createCell(2);
		head_cell_1.setCellValue("��Ʒ����");
		//head_cell_1.setCellStyle(headStyle);
		HSSFCell head_cell_4 = headRow.createCell(3);
		head_cell_1.setCellValue("��Ʒ����");
		//head_cell_1.setCellStyle(headStyle);
		HSSFCell head_cell_5 = headRow.createCell(4);
		head_cell_1.setCellValue("��Ʒ�۸�");
		//head_cell_1.setCellStyle(headStyle);
		HSSFCell head_cell_6 = headRow.createCell(5);
		head_cell_1.setCellValue("��Ʒ����");
		//head_cell_1.setCellStyle(headStyle);
		HSSFCell head_cell_7 = headRow.createCell(6);
		head_cell_1.setCellValue("��Ч����");
		//head_cell_1.setCellStyle(headStyle);
		
		//��ͷ����������������
		for (int i = 1; i <= list.size(); i++) {
			//��������
			HSSFRow contentRow = sheet_1.createRow(i);
			//��������
			HSSFCell content_cess_1 = contentRow.createCell(0);
			content_cess_1.setCellValue(list.get(i-1).getGood_id());
			//������ʽ.....
			
			HSSFCell content_cess_2 = contentRow.createCell(1);
			content_cess_2.setCellValue(list.get(i-1).getGood_id());
			//������ʽ.....
			HSSFCell content_cess_3 = contentRow.createCell(2);
			content_cess_3.setCellValue(list.get(i-1).getGood_id());
			//������ʽ.....
			HSSFCell content_cess_4 = contentRow.createCell(3);
			content_cess_4.setCellValue(list.get(i-1).getGood_id());
			//������ʽ.....
			HSSFCell content_cess_5 = contentRow.createCell(4);
			content_cess_5.setCellValue(list.get(i-1).getGood_id());
			//������ʽ.....
			HSSFCell content_cess_6 = contentRow.createCell(5);
			content_cess_6.setCellValue(list.get(i-1).getGood_id());
			//������ʽ.....
			HSSFCell content_cess_7 = contentRow.createCell(6);
			content_cess_7.setCellValue(list.get(i-1).getGood_id());
			//������ʽ.....
		}
		
		//ͨ������� ���ص��ͻ���
		String fileName = new String("goodsInfo.xls".getBytes("utf-8"), "ISO-8859-1");
		
		//��Ӧ
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
