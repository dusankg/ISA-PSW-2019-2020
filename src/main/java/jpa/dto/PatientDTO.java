package jpa.dto;



import jpa.modeli.Patient;

public class PatientDTO {
	private long id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String adress;
	private String city;
	private String state;
	private int phone;
	private int lbo;
	private boolean validated;
	
	
	public PatientDTO() {
		
	}
	
	
	public PatientDTO(long id2, String name2, String surname2, String email2, String password2, String adress2,
			String city2,String state2, int phone2,int lbo2) {
		this.id=id2;
		this.name=name2;
		this.surname=surname2;
		this.email=email2;
		this.password=password2;
		this.adress=adress2;
		this.city=city2;
		this.state=state2;
		this.phone=phone2;
		this.lbo=lbo2;
		this.validated = false;
	}
	
	public PatientDTO(Patient patient) {
		this.id=patient.getId();
		this.name=patient.getName();
		this.surname=patient.getSurname();
		this.email=patient.getEmail();
		this.password=patient.getPassword();
		this.adress=patient.getAdress();
		this.city=patient.getCity();
		this.state=patient.getState();
		this.phone=patient.getPhone();
		this.lbo=patient.getLbo();
		this.validated = patient.isValidated();
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


	public boolean isValidated() {
		return validated;
	}


	public void setValidated(boolean validated) {
		this.validated = validated;
	}


	

	
	
	
	
	
	
}
