package Picture;

public abstract class Picture {
	
	protected int numOfSided ; //�ߵ�����
	protected boolean center; //�Ƿ������ĵ�
	protected boolean symmetry; //�Ƿ�Գ�

	
	
	
	public int getNumOfSided() {
		return numOfSided;
	}

	public void setNumOfSided(int numOfSided) {
		this.numOfSided = numOfSided;
	}

	public boolean isCenter() {
		return center;
	}

	public void setCenter(boolean center) {
		this.center = center;
	}

	public boolean isSymmetry() {
		return symmetry;
	}

	public void setSymmetry(boolean symmetry) {
		this.symmetry = symmetry;
	}

	
	
	
	
	
	
	
	
	
	
	
	public Picture(boolean symmetry) {
		super();
		this.symmetry = symmetry;
	}

	public Picture() {
		super();
	}

	public Picture(int numOfSided, boolean center, boolean symmetry) {
		super();
		this.numOfSided = numOfSided;
		this.center = center;
		this.symmetry = symmetry;
	}

	abstract void darw();
	
}
