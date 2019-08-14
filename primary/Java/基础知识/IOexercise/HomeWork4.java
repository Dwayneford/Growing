package IO.HomeWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HomeWork4 {

	public static void main(String[] args) throws Exception, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:/IO����/objectFile.txt"));
		//���л�����
		School sch = new School("����", "�����ֵ�");
		out.writeObject(sch);
		out.close();
		
		//�����л�����
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:/IO����/objectFile.txt"));
		School sch2= (School) in.readObject();
		System.out.println("�����л���Ϣ����:"+sch2);
		in.close();
	}
	
}

class School implements Serializable{
	private String name;
	private String address;
	public School(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return name + " " + address;
	}
	
	
}
