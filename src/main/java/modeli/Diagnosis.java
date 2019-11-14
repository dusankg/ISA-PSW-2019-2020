package modeli;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

public class Diagnosis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	//@ManyToMany
		//@JoinTable(name = "diagnosed", joinColumns = @JoinColumn(name = "diagnosis_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"))
		//private Set<Diagnosis> diagnosiss = new HashSet<Diagnosis>();
		//Need to be added after all of the classes have been done correctly
		
	public Diagnosis(){
		
	}

	public Diagnosis(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}	