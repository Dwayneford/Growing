package FanxingLianxi.NewsSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NewsInfo<E> {

	
	public static void main(String[] args) {
		
		Map map = new HashMap();
		String flag;
		String newsId;
		String newsTitle;
		String newsContent;
		String newsDate;
		
		while (true) {
			System.out.println("< < < < < < 使用ArrayList实现新闻管理系统 > > > > > >");
			System.out.println("1. 添加新闻");
			System.out.println("2. 查询新闻");
			System.out.println("3. 删除新闻");
			System.out.println("4. 退出");
			System.out.println("请选择功能（1，2，3，4）：");

			Scanner scanner = new Scanner(System.in);
			int num = scanner.nextInt();
			switch (num) {
			case 1:
				do {
					System.out.println("请输入新闻编号：");				
					newsId=scanner.next();
					System.out.println("请输入新闻标题：");
					newsTitle=scanner.next();
					System.out.println("请输入新闻内容：");
					newsContent=scanner.next();
					System.out.println("请输入发布时间：");
					newsDate=scanner.next();
					
					ArrayList lis = new ArrayList();  //必须定义在里面
					lis.add(newsId);
					lis.add(newsTitle);
					lis.add(newsContent);
					lis.add(newsDate);
					map.put(newsId, lis);
					System.out.println("添加成功！");
					System.out.println("是否继续添加新闻？(Y or N)");
					flag=scanner.next();
				} while ("y".equals(flag)|| "Y".equals(flag));
				
				break;
			case 2:
				System.out.println("新闻内容如下：");
				System.out.println("====================================================");
				System.out.println("编号	" + "标题	"+"内容	");
				
				Set set = map.keySet();
				Iterator iter =set.iterator();
				while (iter.hasNext()) {
					String str = (String) iter.next();
					List lis = (List) map.get(str);
					System.out.println(lis.get(0)+"\t"+lis.get(1)+"\t"+lis.get(2));
				}
				System.out.println("====================================================");
				break;
			case 3:
				System.out.println("请输入删除的新闻编号：");	
				newsId = scanner.next();
				if (map.containsKey(newsId)) {
					map.remove(newsId);
					System.out.println("删除成功！");
				}else{
					System.out.println("没有找到您想删除的新闻！");
				}
				
				break;
			
			case 4:
				System.out.println("感谢您使用本系统！");
				scanner.close();
				return;   
			default:
				System.out.println("请输入正确的数字！");
				break;
			}
		}
		
		
	}
	
	

	
	
	
//	protected String getNewsId() {
//		return newsId;
//	}
//	public void setNewsId(String newsId) {
//		this.newsId = newsId;
//	}
//	public String getNewsTitle() {
//		return newsTitle;
//	}
//	public void setNewsTitle(String newsTitle) {
//		this.newsTitle = newsTitle;
//	}
//	public String getNewsContent() {
//		return newsContent;
//	}
//	public void setNewsContent(String newsContent) {
//		this.newsContent = newsContent;
//	}
//	public String getNewsDate() {
//		return newsDate;
//	}
//	public void setNewsDate(String newsDate) {
//		this.newsDate = newsDate;
//	}
//	public NewsInfo(String newsId, String newsTitle, String newsDate, String newsContent) {
//		super();
//		this.newsId = newsId;
//		this.newsTitle = newsTitle;
//		this.newsContent = newsContent;
//		this.newsDate = newsDate;
//	}
	
	
//	public NewsInfo() {
//		super();
//	}
//	//查询新闻
//	@Override
//	public String toString() {
//		return "NewsInfo [lis=" + lis + ", newsId=" + newsId + ", newsTitle=" + newsTitle + ", newsContent="
//				+ newsContent + "]";
//	}
//	
//	
//	void showAllNews(){
//		Iterator iter = lis.iterator();
//		System.out.println("编号		" + "标题	"+"内容		");
//		for (NewsInfo newsInfo : lis) {
//			System.out.println(newsInfo);
//		}
//	}
//	void addNews(){
//		NewsInfo news=new NewsInfo();
//		System.out.println("请输入新闻编号：");
//		Scanner sca =new Scanner(System.in);
//		newsId=sca.next();
//		System.out.println("请输入新闻标题：");
//		newsTitle=sca.next();
//		System.out.println("请输入新闻内容：");
//		newsContent=sca.next();
//		System.out.println("请输入发布时间：");
//		newsDate=sca.next();
//		news.setNewsId(newsId);
//		news.setNewsTitle(newsTitle);
//		news.setNewsContent(newsContent);
//		news.setNewsDate(newsDate);
//		lis.add(news);
//		sca.close();
//	}
//	void deleteNews(int newsId){
//		lis.remove(newsId);
//	}
}
