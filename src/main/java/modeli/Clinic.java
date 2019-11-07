package modeli;

import java.util.HashSet;
import java.util.Set;

public class Clinic {
	public long id;
	
	private String name;
	private String adress;
	private String description;
	private double gradeSum; //Prosek je gradeSum podeljeno sa gradeNumber
	private int gradeNumber;
	private Set<Doctor> doktori = new HashSet<Doctor>();
	private Set<MedicalRoom> rooms=new HashSet<MedicalRoom>();
	private Set<Examination> examinations =new HashSet<Examination>();
	private Set<Prescription>prescriptions=new HashSet<Prescription>();
	//Cenovnik
	// Treba da ima spiasak slobodnih termina, sala i doktora

	public Clinic(String name, String adress, String description) {
		super();
		this.name = name;
		this.adress = adress;
		this.description = description;
		this.gradeSum = 0;
		this.gradeNumber = 1;
	}
	
	public Clinic(String name, String adress, String description, double gradeSum, int gradeNumber) {
		super();
		this.name = name;
		this.adress = adress;
		this.description = description;
		this.gradeSum = gradeSum;
		this.gradeNumber = gradeNumber;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getGradeSum() {
		return gradeSum;
	}

	public void setGradeSum(double gradeSum) {
		this.gradeSum = gradeSum;
	}

	public int getGradeNumber() {
		return gradeNumber;
	}

	public void setGradeNumber(int gradeNumber) {
		this.gradeNumber = gradeNumber;
	}

	public Set<Doctor> getDoktori() {
		return doktori;
	}

	public void setDoktori(Set<Doctor> doktori) {
		this.doktori = doktori;
	}

	public Set<MedicalRoom> getRooms() {
		return rooms;
	}

	public void setRooms(Set<MedicalRoom> rooms) {
		this.rooms = rooms;
	}

	public Set<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(Set<Examination> examinations) {
		this.examinations = examinations;
	}

	public Set<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	
}
