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
	
	
	/*����excel�Ĺ����ࣺ���� jxl ��poi
	
	���ʹ�ã��������߰�
		��������jar��
			jxl-2.6.12.jar
			poi-3.17.jar
			poi-ooxml-3.15.jar
			poi-ooxml-schemas-3.15.jar
			
	����excel�ĳ��÷�����
		//������д���excel������
		WritableWorkbook wwb =	Workbook.createWorkbook(new File("�ļ����·��"));
		//д�뵽����
		OutputStream os= new FileOutputStream("�ļ����·��");
		
		//������
		WritableSheet ws = wwb.createSheet("������", 0);
		
		//��Ԫ��
		Label label = new Label(0, 0, "��Ԫ������");
		
		//���õ�Ԫ�� ��ʽ
		WritableFont font =	new WritableFont(WritableFont.ARIAL,18,WritableFont.BOLD);
		
		// ��Ԫ������ֶΣ��ַ��� ʱ��  boolean���� ��ʽ ͼƬ �ȵ� ����
		//���number
		Number lableN = new Number(0, 1, 3.1415296);
		ws.addCell(lableN);
		//ʱ�����
		DateTime lableDt = new DateTime(0, 2, new Date());
		ws.addCell(lableDt);
		//ͼƬ����
		WritableImage wrimage =	new WritableImage(0, 5, 15, 15, new File("imgPath"));
		ws.addImage(wrimage);
		
		//��ʽ
		Formula formulal=new Formula(0, 11, "Sum(A1:A9)");
		//........
		
		//�ϲ���Ԫ��  �ӵ�x+1��  y+1��  ��m+1�� n+1�кϲ�
		ws.mergeCells(0, 0, 9, 0);
		
		
		��ȡExcel?
			//1. ѡȡexcel�ĵ�
			Workbook workbook = Workbook.getWorkbook(new File("myfile.xls"));
			
			//2.��ȡ ������
			Sheet sheet = workbook.getSheet(0);
			//3.��ȡ����
			Cell c2= sheet.getCell(2, 1);
			
			//4 ȡ����
			String string2 = c2.getContents();
			//����ͨ�� celltype ȷ���������ͣ� DATE NUMBER....
			//5 �ͷ���Դ
			workbook.close();
	*/
	/**
	 * �������
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
	 * ����ѧ����Ϣ excel����
	 * @throws IOException 
	 */
	public void createFormtStud(String filePath) throws Exception{
		//�����ļ�λ��
		File stuFile = new File(filePath);
		//��ȡ������
		WritableWorkbook  wwb = Workbook.createWorkbook(stuFile);
		
		//�ж��Ƿ����
		if(wwb!=null){
			//����������
			WritableSheet ws = wwb.createSheet("������ѧϰ��Ϣ", 0);
			//���ñ�����
			ws.mergeCells(0, 0, 9, 0);
			//����ͷ������
			String[] strs={"ѧ��","����","�Ա�","���֤","�绰","����","��ַ","���ѵ绰","��ϵ��","��ѧʱ��"};
			//ȷ�� excel�����Ҫ����ʽ
			//�����ʽ1
			WritableFont font1 =new WritableFont(WritableFont.TAHOMA, 18, WritableFont.BOLD);
			//�����ʽ2
			WritableFont font2 =new WritableFont(WritableFont.ARIAL, 13, WritableFont.BOLD);
			
			//��ʽ����Ԫ��
			WritableCellFormat format1 = new WritableCellFormat(font1);
			WritableCellFormat format2 = new WritableCellFormat(font2);
			WritableCellFormat format3 = new WritableCellFormat();
			
			//�������ݾ���
			format1.setAlignment(jxl.format.Alignment.CENTRE);
			//��ֱ����
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			//��ӱ߿�
			format1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			
			format2.setAlignment(jxl.format.Alignment.CENTRE);
			format2.setBackground(jxl.format.Colour.PINK);
			//�Զ�����
			format2.setWrap(true);
			
			format3.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			format3.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			format3.setAlignment(jxl.format.Alignment.CENTRE);
			
			//���ø߶�
			ws.setRowView(0, 700);
			
			//��������
			Label label = new Label(0, 0, "yc123�༶ѧ����Ϣ��",format1);
			//���
			ws.addCell(label);
			//�����еĿ��
			for (int i = 0; i < 10; i++) {
				Label lblc = new Label(i,1,strs[i],format2);
				
				if(i==0){
					//���ÿ��
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
				//��ӵ���Ԫ����
				ws.addCell(lblc);
			}
			
			//�����ݿ���ȡ������ ѭ�� ���ɵ� excel��
			for (int i = 2; i < 22; i++) {
				
				for (int j = 0; j < 10; j++) {
					
					Label lab = new Label(j, i, "���ǵ�"+(i+j)+"����",format3);
					ws.addCell(lab);
				}
			}
			//д���ļ�
			wwb.write();
			wwb.close();
			System.out.println("===OK==");
		}
		
	}
	
	
	/**
	 * ����excel
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public void inversExcel() throws BiffException, IOException{
		//��ȡ�ļ�
		File xlsFile = new File("d://studentInfo.xls");
		//��ȡ����������
		Workbook workbook = Workbook.getWorkbook(xlsFile);
		//��ȡ���еĹ�����
		Sheet[] sheets = workbook.getSheets();
		//�ж� �Ƿ�Ϊ��
		if(sheets!=null){
			//����
			for (Sheet sheet : sheets) {
				//��ȡ��
				int rows = sheet.getRows();
				//��ȡ��
				int cols = sheet.getColumns();
				//��ȡ����
				for (int row = 0; row < rows; row++) {
					for (int col = 0; col < cols; col++) {
						//��װΪ����
						System.out.printf("%10s",sheet.getCell(col, row).getContents());
					}
					System.out.println();
				}
			}
			
		}
		workbook.close();
	}
		
	/**
	 * �򵥴��� excel ���� ��
	 * @throws Exception 
	 */
	public void createExcel() throws Exception{
		File xlsFile = new File("d://studentInfo.xls");
		//���� ���� ��
		WritableWorkbook workBook = Workbook.createWorkbook(xlsFile);
		//����������
		WritableSheet sheet = workBook.createSheet("ѧ�� ��Ϣ��", 0);
		
		//ȡ�����ݿ��е����� ��ŵ�����
		for(int row=0; row<10;row++){
			for (int col=0; col<10; col++) {
				//����Ԫ���� ׷������
				Label label = new Label(col, row, "stuInfo"+row+col);
				//��ŵ����������
				sheet.addCell(label);
			}
		}
		
		//д ��  �ر�
		workBook.write();
		workBook.close();
	}
	

}
