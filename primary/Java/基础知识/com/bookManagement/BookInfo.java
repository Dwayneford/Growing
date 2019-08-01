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
	
	//��װ�ӿ�
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
	//���캯��
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
	
	//����
	//���۸�
	void checkPrice(double bookPrice){
		this.bookPrice=bookPrice;
		if(bookPrice<=0){
			System.out.println("ͼ��ļ۸񲻺Ϸ���");
		}
		
	}
	//����ͼ��
	void introduceBookInfo(int bookId, String bookName, String bookAuther, double bookPrice, int bookPublishDate){
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuther = bookAuther;
		this.bookPrice = bookPrice;
		this.bookPublishDate = bookPublishDate;
		System.out.println("ͼ������֣�"+bookName+"ͼ���ID��"+bookId+"ͼ������ߣ�"+bookAuther+"ͼ��ļ۸�"+bookPrice+"ͼ�����ʱ�䣺"+bookPublishDate);				
	}
	//�ж��û��Ƿ�Ϸ�
	boolean  checkAccount(){
		Scanner sca =new Scanner(System.in);
		System.out.println("�������˻����룺");
		int a= sca.nextInt();
		System.out.println("���������룺");
		String b=sca.next();
		boolean x;
		if(a==accountNum && b.equals(accountPwd)){
			
			x =true;
		System.out.println("�˻���֤�ɹ���");
		}else{
			x =false;
			System.out.println("�˻���֤ʧ��");
		}
		sca.close();
		return x;
		
	}
	//���ͼ��
	void addBook(){
		String[][] addBook = new String[10][5];
//		checkAccount();
		boolean x=checkAccount();
		while (x) {
			
			Scanner sca =new Scanner(System.in);
			
			System.out.println("������������");
			String bookName= sca.next();
			System.out.println("������ID��");
			String bookID= sca.next();
			System.out.println("���������ߣ�");
			String bookAuther= sca.next();
			System.out.println("������۸�");
			String bookPrice= sca.next();
			System.out.println("���������ߣ�");
			String bookPublishDate= sca.next();
			
			System.out.println("������ɣ�");
			
			
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
