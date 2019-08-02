package com.yc123.demo;


public class BookInfo {
	//属性
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double bookPrice;
	private String bookPublishDate;
	//对外提供 get set 方法 访问私有属性;
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
	
	//构造函数
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
	 * 对象 提供的 方法，判断书的价格是否合法
	 *  书必须：大于0元 ，单本书小于 200 元
	 */
	public boolean priceTrueOrFasle(double bookPrice){
		//定义返回的变量
		boolean priceBool = false;
		if(bookPrice<0 || bookPrice>200){
			priceBool = false;
		}else{
			priceBool = true;
		}
		return priceBool;
	}
	
	/**
	 * 介绍书本信息 方法
	 */
	public String sayBookInfo(BookInfo bookEnt){
		//定义返回的字符串
		String retStr = "";
		retStr+="书本的明显介绍：名称<<"+bookEnt.getBookName()+">>,作者为："+bookEnt.getBookAuthor()+
							 ",价格为：￥"+bookEnt.getBookPrice()+"元,"+ 
							 "出版日期为："+bookEnt.getBookPublishDate();
		return retStr;
	}
	
	/**
	 * 判断用户 是否合法
	 *    先存入用信息：用户名 和 密码
	 *    	static 修饰符 修饰用户属性
	 */
	public static String userName="admin";
	public static String userPwd ="123456";
	
	public boolean isLogin(String queName,String quePwd){
		//定义返回的 变量
		boolean bool = false;
		//判断逻辑
		if(userName.equals(queName) && userPwd.equals(quePwd)){
			bool = true;
			System.out.println("登陆成功！！！");
		}else if(!userName.equals(queName) || !userPwd.equals(quePwd)){
			bool = false;
			System.out.println("用户名 或者 密码错误");
		}
		
		return bool;
	}
  
	//定义 一个成员变量 数组
	BookInfo[] bookArrys = new BookInfo[50];
	//定义变量 int类型 赋初始值 0 变量为静态；
	static int bookNum = 0;
	 /**
	   * 定义 一个添加图书的 方法	
	   */
	public Boolean addBook(BookInfo bookEnt,String logName, String logPwd){
		//返回变量  == 
		boolean addBookBool = false;
		// 判断用户名 密码 是否正确，正确则添加 否则 添加失败!!!!
	 	boolean bool = this.isLogin(logName, logPwd);
	 	if (bool) {
	 		if(bookNum>=50){
	 			System.out.println("数组中 已经添满 ，不能再添加数据了....");
	 			return false;
	 		}
	 		//往数组中添加书本信息
	 		bookArrys[bookNum] = bookEnt;
	 		//改变静态变量的值
	 		bookNum++;
	 		//输出添加信息
	 		System.out.println("书本 信息："+bookEnt.toString());
	 		
	 		
			System.out.println("添加成功！！！");
		}else{
			addBookBool = false;
			System.out.println("用户名/密码错误,添加数据 失败！！！");
		}
		return addBookBool;
	}
	
	@Override
	public String toString() {
		return "BookInfo [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPrice="
				+ bookPrice + ", bookPublishDate=" + bookPublishDate + "]";
	}
	

}
