package jpa.dto;

import java.util.HashSet;
import java.util.Set;

import jpa.modeli.Clinic;
import jpa.modeli.Doctor;
import jpa.modeli.Examination;
import jpa.modeli.Patient;

public class DoctorDTO {
		
	private Long id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String adress;
	private String city;
	private String state;
	private Clinic clinic;
	private int phone;
	private Set<Patient>patient=new HashSet<Patient>();
	// private Set<Examination> examinations=new HashSet<Examination>();
public DoctorDTO() {
		
	}
		
	public DoctorDTO(Doctor doctor) {
		this(doctor.getId(), doctor.getName(), doctor.getSurname(), doctor.getEmail(), doctor.getPassword(), doctor.getAdress(), doctor.getCity(), doctor.getState(), doctor.getPhone());
	}
	
	public DoctorDTO(Long id,String name, String surname, String email, String password, String adress, String city, String state,
		int phone) {
		super();
		this.id=id;
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

		/*
		public Set<Examination> getExaminations() {
			return examinations;
		}


		public void setExaminations(Set<Examination> examinations) {
			this.examinations = examinations;
		}
		 */
		public Clinic getClinic() {
			return clinic;
		}


		public void setClinic(Clinic clinic) {
			this.clinic = clinic;
		}

}
