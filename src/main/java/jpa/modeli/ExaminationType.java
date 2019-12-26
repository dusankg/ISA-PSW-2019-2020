package jpa.modeli;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExaminationType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "typename")
	private String typeName;
	
	public ExaminationType() {}
	
	public ExaminationType(String typeName) {
		super();
		this.typeName = typeName;
	}
	
	public Long getId() {
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
