package add_delete_select;

import java.io.Serializable;

// µÃÂ¿‡
public class Manager implements Serializable {

	private int id;
	private String name;
	private int work;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWork() {
		return work;
	}
	public void setWork(int work) {
		this.work = work;
	}
	public Manager(int id, String name, int work) {
		super();
		this.id = id;
		this.name = name;
		this.work = work;
	}
	public Manager() {
		super();
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", work=" + work + "]";
	}
	
}
