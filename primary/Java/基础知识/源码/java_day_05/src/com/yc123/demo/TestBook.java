package com.yc123.demo;

public class TestBook {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//���� ���� ���� ����  �������
		BookInfo bookInfo1 = new BookInfo();
		bookInfo1.setBookId(100001);
		bookInfo1.setBookName("ˮ䰴�");
		bookInfo1.setBookAuthor("ʩ����");
		bookInfo1.setBookPrice(199.9);
		bookInfo1.setBookPublishDate("1988-5-20");
		
		BookInfo bookInfo2 = new BookInfo();
		bookInfo2.setBookId(100002);
		bookInfo2.setBookName("���μ�");
		bookInfo2.setBookAuthor("��ж�");
		bookInfo2.setBookPrice(59.9);
		bookInfo2.setBookPublishDate("1958-5-20");
		
		BookInfo bookInfo3 = new BookInfo();
		bookInfo3.setBookId(100003);
		bookInfo3.setBookName("��������");
		bookInfo3.setBookAuthor("�޹���");
		bookInfo3.setBookPrice(199.9);
		bookInfo3.setBookPublishDate("1768-5-20");
		
		//���� ���ݹ������û���������
		String logName = "admin";
		String logPwd = "123456";
		
		//���� book����� ����������ݷ���
		BookInfo bookMeth = new BookInfo();
		
		bookMeth.addBook(bookInfo1, logName, logPwd);
		bookMeth.addBook(bookInfo2, logName, logPwd);
		bookMeth.addBook(bookInfo3, logName, logPwd);
		
		//��������е� ������Ϣ
		for (int i = 0; i < 3; i++) {
			BookInfo bkEnt = bookMeth.bookArrys[i];
			System.out.println(bkEnt.toString());
		}
		
		
		
	}
}
