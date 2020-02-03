package jpa.modeli;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Occupation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "startingDate")
	private Date startingTime;
	@Column(name = "duration")
	private int durationMinutes;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private MedicalRoom medicalRoom;
	
	public Occupation() {
		super();
	}
	public Occupation(Date pocetak, int duration) {
		super();
		this.startingTime = pocetak;
		this.durationMinutes = duration;
	}
	public Date getPocetak() {
		return startingTime;
	}
	public void setPocetak(Date pocetak) {
		this.startingTime = pocetak;
	}
	public int getDurationMinutes() {
		return durationMinutes;
	}
	public void setDurationMinutes(int duration) {
		this.durationMinutes = duration;
	}
	
	
	
}
