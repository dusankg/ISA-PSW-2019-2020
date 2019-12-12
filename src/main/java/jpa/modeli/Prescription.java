package jpa.modeli;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Prescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "validated")
	private boolean validated;
	
	
	
	public Prescription(boolean validated) {
		super();
		this.validated = validated;
		this.validated = false;
	}
	public Prescription(String naziv, boolean validated) {
		super();
		this.name = naziv;
		this.validated = validated;
	}
	public Prescription(Long id, String naziv, boolean validated) {
		super();
		this.id = id;
		this.name = naziv;
		this.validated = validated;
	}
	public Prescription() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String naziv) {
		this.name = naziv;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	
	
	
	
}
