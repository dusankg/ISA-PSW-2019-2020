package jpa.modeli;

public class ExaminationType {

	private long id;
	
	private String typeName;
	
	public ExaminationType(double price, String typeName) {
		super();
		this.typeName = typeName;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
