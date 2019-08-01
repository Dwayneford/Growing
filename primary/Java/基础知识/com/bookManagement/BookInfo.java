package com.bookManagement;


import java.util.Scanner;

public class BookInfo {

	
	static private int accountNum =12345;
	static private String accountPwd ="asd123";
	
	private int bookId;
	private String bookName;
	private String bookAuther;
	private double bookPrice;
	private int bookPublishDate;
	
	//封装接口
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuther() {
		return bookAuther;
	}
	public void setBookAuther(String bookAuther) {
		this.bookAuther = bookAuther;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getBookPublishDate() {
		return bookPublishDate;
	}
	public void setBookPublishDate(int bookPublishDate) {
		this.bookPublishDate = bookPublishDate;
	}
	//构造函数
	public BookInfo() {
		super();
	}
	public BookInfo(int bookId, String bookName, String bookAuther, double bookPrice, int bookPublishDate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuther = bookAuther;
		this.bookPrice = bookPrice;
		this.bookPublishDate = bookPublishDate;
	}
	
	//方法
	//检查价格
	void checkPrice(double bookPrice){
		this.bookPrice=bookPrice;
		if(bookPrice<=0){
			System.out.println("图书的价格不合法！");
		}
		
	}
	//介绍图书
	void introduceBookInfo(int bookId, String bookName, String bookAuther, double bookPrice, int bookPublishDate){
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuther = bookAuther;
		this.bookPrice = bookPrice;
		this.bookPublishDate = bookPublishDate;
		System.out.println("图书的名字："+bookName+"图书的ID："+bookId+"图书的作者："+bookAuther+"图书的价格："+bookPrice+"图书出版时间："+bookPublishDate);				
	}
	//判断用户是否合法
	boolean  checkAccount(){
		Scanner sca =new Scanner(System.in);
		System.out.println("请输入账户号码：");
		int a= sca.nextInt();
		System.out.println("请输入密码：");
		String b=sca.next();
		boolean x;
		if(a==accountNum && b.equals(accountPwd)){
			
			x =true;
		System.out.println("账户验证成功！");
		}else{
			x =false;
			System.out.println("账户验证失败");
		}
		sca.close();
		return x;
		
	}
	//添加图书
	void addBook(){
		String[][] addBook = new String[10][5];
//		checkAccount();
		boolean x=checkAccount();
		while (x) {
			
			Scanner sca =new Scanner(System.in);
			
			System.out.println("请输入书名：");
			String bookName= sca.next();
			System.out.println("请输入ID：");
			String bookID= sca.next();
			System.out.println("请输入作者：");
			String bookAuther= sca.next();
			System.out.println("请输入价格：");
			String bookPrice= sca.next();
			System.out.println("请输入作者：");
			String bookPublishDate= sca.next();
			
			System.out.println("输入完成！");
			
			
			for(int i=0; i<5;i++){
				if(addBook[i] != null){					
					i++;
				}else{
					addBook[i][0]=bookName;
					addBook[i][1]=bookID;
					addBook[i][2]=bookAuther;
					addBook[i][3]=bookPrice;
					addBook[i][4]=bookPublishDate;
					
					for(String temp: addBook[i]){
						System.out.println(temp);
					}
				}
				
			}
			sca.close();
		}
		
		
	}
	
	
}
