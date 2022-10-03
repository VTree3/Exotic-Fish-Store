package Model;

public abstract class Fish {
	protected String id;
	protected String name;
	protected float size;
	protected int speed;
	protected int price;
	public Fish(String id, String name, float size, int speed, int price) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.speed = speed;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public abstract void print();
	
}
