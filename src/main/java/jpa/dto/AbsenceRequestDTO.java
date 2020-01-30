package jpa.dto;

import java.util.Date;

import jpa.modeli.AbsenceRequest;

public class AbsenceRequestDTO {
	private Long id;
	private Date startingDate;
	private Date endingDate;
	private DoctorDTO doctor;
	
	public AbsenceRequestDTO() {}
	
	public AbsenceRequestDTO(AbsenceRequest absenceRequest) {
		this.id = absenceRequest.getId();
		this.startingDate = absenceRequest.getStartingDate();
		this.endingDate = absenceRequest.getEndingDate();
		this.doctor = new DoctorDTO(absenceRequest.getDoctor());
	}
	
	public AbsenceRequestDTO(Long id, Date startingDate, Date endingDate) {
		super();
		this.id = id;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.doctor = new DoctorDTO();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public DoctorDTO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDTO doctorDTO) {
		this.doctor = doctorDTO;
	}
	
	
}
