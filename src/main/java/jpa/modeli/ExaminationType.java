package jpa.modeli;

public class ExaminationType {

	private long id;
	
	private double price;
	private String typeName;
	
	public ExaminationType(double price, String typeName) {
		super();
		this.price = price;
		this.typeName = typeName;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
