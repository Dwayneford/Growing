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
			System.out.println("< < < < < < ʹ��ArrayListʵ�����Ź���ϵͳ > > > > > >");
			System.out.println("1. �������");
			System.out.println("2. ��ѯ����");
			System.out.println("3. ɾ������");
			System.out.println("4. �˳�");
			System.out.println("��ѡ���ܣ�1��2��3��4����");

			Scanner scanner = new Scanner(System.in);
			int num = scanner.nextInt();
			switch (num) {
			case 1:
				do {
					System.out.println("���������ű�ţ�");				
					newsId=scanner.next();
					System.out.println("���������ű��⣺");
					newsTitle=scanner.next();
					System.out.println("�������������ݣ�");
					newsContent=scanner.next();
					System.out.println("�����뷢��ʱ�䣺");
					newsDate=scanner.next();
					
					ArrayList lis = new ArrayList();  //���붨��������
					lis.add(newsId);
					lis.add(newsTitle);
					lis.add(newsContent);
					lis.add(newsDate);
					map.put(newsId, lis);
					System.out.println("��ӳɹ���");
					System.out.println("�Ƿ����������ţ�(Y or N)");
					flag=scanner.next();
				} while ("y".equals(flag)|| "Y".equals(flag));
				
				break;
			case 2:
				System.out.println("�����������£�");
				System.out.println("====================================================");
				System.out.println("���	" + "����	"+"����	");
				
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
				System.out.println("������ɾ�������ű�ţ�");	
				newsId = scanner.next();
				if (map.containsKey(newsId)) {
					map.remove(newsId);
					System.out.println("ɾ���ɹ���");
				}else{
					System.out.println("û���ҵ�����ɾ�������ţ�");
				}
				
				break;
			
			case 4:
				System.out.println("��л��ʹ�ñ�ϵͳ��");
				scanner.close();
				return;   
			default:
				System.out.println("��������ȷ�����֣�");
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
//	//��ѯ����
//	@Override
//	public String toString() {
//		return "NewsInfo [lis=" + lis + ", newsId=" + newsId + ", newsTitle=" + newsTitle + ", newsContent="
//				+ newsContent + "]";
//	}
//	
//	
//	void showAllNews(){
//		Iterator iter = lis.iterator();
//		System.out.println("���		" + "����	"+"����		");
//		for (NewsInfo newsInfo : lis) {
//			System.out.println(newsInfo);
//		}
//	}
//	void addNews(){
//		NewsInfo news=new NewsInfo();
//		System.out.println("���������ű�ţ�");
//		Scanner sca =new Scanner(System.in);
//		newsId=sca.next();
//		System.out.println("���������ű��⣺");
//		newsTitle=sca.next();
//		System.out.println("�������������ݣ�");
//		newsContent=sca.next();
//		System.out.println("�����뷢��ʱ�䣺");
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
