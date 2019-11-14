package modeli;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "surname", nullable = false)
	private String surname;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "adress")
	private String adress;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Clinic clinic;
	
	@Column(name = "column")
	private int phone;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Patient>patient=new HashSet<Patient>();
	
	@OneToMany(mappedBy = "examination", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Examination> examinations=new HashSet<Examination>();
	
	
	public Doctor() {}
	
	public Doctor(String name, String surname, String email, String password, String adress, String city, String state,
			int phone) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.adress = adress;
		this.city = city;
		this.state = state;
		this.phone = phone;
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


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public Set<Patient> getPatient() {
		return patient;
	}


	public void setPatient(Set<Patient> patient) {
		this.patient = patient;
	}


	public Set<Examination> getExaminations() {
		return examinations;
	}


	public void setExaminations(Set<Examination> examinations) {
		this.examinations = examinations;
	}


	public Clinic getClinic() {
		return clinic;
	}


	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	
	
}
