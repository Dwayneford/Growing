package com.yc123.demo;


public class BookInfo {
	//����
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double bookPrice;
	private String bookPublishDate;
	//�����ṩ get set ���� ����˽������;
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
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public String getBookPublishDate() {
		return bookPublishDate;
	}
	public void setBookPublishDate(String bookPublishDate) {
		this.bookPublishDate = bookPublishDate;
	}
	
	//���캯��
	public BookInfo() {
		super();
	}
	public BookInfo(int bookId, String bookName, String bookAuthor, double bookPrice, String bookPublishDate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookPublishDate = bookPublishDate;
	}
	public BookInfo(String bookName, String bookAuthor) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}
	
	/**
	 * ���� �ṩ�� �������ж���ļ۸��Ƿ�Ϸ�
	 *  ����룺����0Ԫ ��������С�� 200 Ԫ
	 */
	public boolean priceTrueOrFasle(double bookPrice){
		//���巵�صı���
		boolean priceBool = false;
		if(bookPrice<0 || bookPrice>200){
			priceBool = false;
		}else{
			priceBool = true;
		}
		return priceBool;
	}
	
	/**
	 * �����鱾��Ϣ ����
	 */
	public String sayBookInfo(BookInfo bookEnt){
		//���巵�ص��ַ���
		String retStr = "";
		retStr+="�鱾�����Խ��ܣ�����<<"+bookEnt.getBookName()+">>,����Ϊ��"+bookEnt.getBookAuthor()+
							 ",�۸�Ϊ����"+bookEnt.getBookPrice()+"Ԫ,"+ 
							 "��������Ϊ��"+bookEnt.getBookPublishDate();
		return retStr;
	}
	
	/**
	 * �ж��û� �Ƿ�Ϸ�
	 *    �ȴ�������Ϣ���û��� �� ����
	 *    	static ���η� �����û�����
	 */
	public static String userName="admin";
	public static String userPwd ="123456";
	
	public boolean isLogin(String queName,String quePwd){
		//���巵�ص� ����
		boolean bool = false;
		//�ж��߼�
		if(userName.equals(queName) && userPwd.equals(quePwd)){
			bool = true;
			System.out.println("��½�ɹ�������");
		}else if(!userName.equals(queName) || !userPwd.equals(quePwd)){
			bool = false;
			System.out.println("�û��� ���� �������");
		}
		
		return bool;
	}
  
	//���� һ����Ա���� ����
	BookInfo[] bookArrys = new BookInfo[50];
	//������� int���� ����ʼֵ 0 ����Ϊ��̬��
	static int bookNum = 0;
	 /**
	   * ���� һ�����ͼ��� ����	
	   */
	public Boolean addBook(BookInfo bookEnt,String logName, String logPwd){
		//���ر���  == 
		boolean addBookBool = false;
		// �ж��û��� ���� �Ƿ���ȷ����ȷ����� ���� ���ʧ��!!!!
	 	boolean bool = this.isLogin(logName, logPwd);
	 	if (bool) {
	 		if(bookNum>=50){
	 			System.out.println("������ �Ѿ����� �����������������....");
	 			return false;
	 		}
	 		//������������鱾��Ϣ
	 		bookArrys[bookNum] = bookEnt;
	 		//�ı侲̬������ֵ
	 		bookNum++;
	 		//��������Ϣ
	 		System.out.println("�鱾 ��Ϣ��"+bookEnt.toString());
	 		
	 		
			System.out.println("��ӳɹ�������");
		}else{
			addBookBool = false;
			System.out.println("�û���/�������,������� ʧ�ܣ�����");
		}
		return addBookBool;
	}
	
	@Override
	public String toString() {
		return "BookInfo [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPrice="
				+ bookPrice + ", bookPublishDate=" + bookPublishDate + "]";
	}
	

}
