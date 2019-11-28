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
import javax.persistence.OneToMany;


@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	@Column(name = "surname", nullable = false)
	private String surname;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "adress", nullable = false)
	private String adress;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "state", nullable = false)
	private String state;
	@Column(name = "phone", nullable = false)
	private int phone;
	@Column(name = "lbo", nullable = false)
	private int lbo; // Licni broj osiguranika
	
	
	
	
	
	//@ManyToMany
	//@JoinTable(name = "diagnosed", joinColumns = @JoinColumn(name = "diagnosis_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"))
	//private Set<Diagnosis> diagnosiss = new HashSet<Diagnosis>();
	//Need to be added after all of the classes have been done correctly
	
	
	public Patient(){
		
	}
	
	// Konstruktor, ali bez zato sto bi on morao sam da se generise
	public Patient(String name, String surname, String email, String password, String adress, String city, String state,
			int phone, int lbo) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.adress = adress;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.lbo = lbo;
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
	public int getLbo() {
		return lbo;
	}
	public void setLbo(int lbo) {
		this.lbo = lbo;
	}
	// for registration just a test
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "insert into patient (name, surname, email, password, adress, city, state, phone, lbo) values ('"+getName()+"', '"+getSurname()+"', '"+getEmail()+"', '"+getPassword()+"', '"+getAdress()+"', '"+getCity()+"', '"+getState()+"', "+getPhone()+", "+getLbo()+");";     

	}
	
	
	
	
	
}
