package Model;

public class SaltwaterFish extends Fish{
	protected String depth;

	public SaltwaterFish(String id, String name, float size, int speed, int price, String depth) {
		super(id, name, size, speed, price);
		this.depth = depth;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Fish ID: "+id);
		System.out.println("Fish Name: "+name);
		System.out.println("Fish Size: "+size);
		System.out.println("Fish Speed: "+speed);
		System.out.println("Algae Tolerance: "+depth);
	}
	

}
