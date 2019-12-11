package jpa.dto;

import java.util.Date;

import jpa.modeli.Examination;

public class ExaminationDTO {

	private Long id;
	private Date date;
	private double duration;
	private double price;
	
	/*
	private ExaminationType type;
	private MedicalRoom room;
	private Doctor doctor;
	*/
	
	public ExaminationDTO() {}
	
	public ExaminationDTO(Examination examination) {
		this(examination.getId(), examination.getDate(), examination.getDuration(), examination.getPrice());
	}
	
	public ExaminationDTO(Long id, Date date, double duration, double price) {
		super();
		this.id = id;
		this.date = date;
		this.duration = duration;
		this.price = price;
		/*
		this.type = type;
		this.room = room;
		this.doctor = doctor;
		*/
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
