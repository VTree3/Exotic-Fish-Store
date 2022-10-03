package Model;

public class FreshwaterFish extends Fish {
	protected int algae;

	public FreshwaterFish(String id, String name, float size, int speed, int price, int algae) {
		super(id, name, size, speed, price);
		this.algae = algae;
	}

	public int getAlgae() {
		return algae;
	}

	public void setAlgae(int algae) {
		this.algae = algae;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
			System.out.println("Fish ID: "+id);
			System.out.println("Fish Name: "+name);
			System.out.println("Fish Size: "+size);
			System.out.println("Fish Speed: "+speed);
			System.out.println("Algae Tolerance: "+algae);
		
	}
	
	
	

}
