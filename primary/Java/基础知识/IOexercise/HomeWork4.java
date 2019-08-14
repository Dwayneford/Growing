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
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:/IO测试/objectFile.txt"));
		//序列化对象
		School sch = new School("足下", "西永街道");
		out.writeObject(sch);
		out.close();
		
		//反序列化对象
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:/IO测试/objectFile.txt"));
		School sch2= (School) in.readObject();
		System.out.println("反序列化信息如下:"+sch2);
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
