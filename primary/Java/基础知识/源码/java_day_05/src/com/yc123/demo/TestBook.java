package com.yc123.demo;

public class TestBook {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//创建 对象 调用 方法  添加数据
		BookInfo bookInfo1 = new BookInfo();
		bookInfo1.setBookId(100001);
		bookInfo1.setBookName("水浒传");
		bookInfo1.setBookAuthor("施耐庵");
		bookInfo1.setBookPrice(199.9);
		bookInfo1.setBookPublishDate("1988-5-20");
		
		BookInfo bookInfo2 = new BookInfo();
		bookInfo2.setBookId(100002);
		bookInfo2.setBookName("西游记");
		bookInfo2.setBookAuthor("吴承恩");
		bookInfo2.setBookPrice(59.9);
		bookInfo2.setBookPublishDate("1958-5-20");
		
		BookInfo bookInfo3 = new BookInfo();
		bookInfo3.setBookId(100003);
		bookInfo3.setBookName("三国演义");
		bookInfo3.setBookAuthor("罗贯中");
		bookInfo3.setBookPrice(199.9);
		bookInfo3.setBookPublishDate("1768-5-20");
		
		//接收 传递过来的用户名和密码
		String logName = "admin";
		String logPwd = "123456";
		
		//创建 book类对象， 调用添加数据方法
		BookInfo bookMeth = new BookInfo();
		
		bookMeth.addBook(bookInfo1, logName, logPwd);
		bookMeth.addBook(bookInfo2, logName, logPwd);
		bookMeth.addBook(bookInfo3, logName, logPwd);
		
		//输出集合中的 对象信息
		for (int i = 0; i < 3; i++) {
			BookInfo bkEnt = bookMeth.bookArrys[i];
			System.out.println(bkEnt.toString());
		}
		
		
		
	}
}
