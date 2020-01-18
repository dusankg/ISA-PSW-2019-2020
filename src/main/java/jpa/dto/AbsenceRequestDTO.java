package jpa.dto;

import java.util.Date;

import jpa.modeli.AbsenceRequest;

public class AbsenceRequestDTO {
	private Long id;
	private Date startingDate;
	private Date endingDate;
	
	public AbsenceRequestDTO() {}
	
	public AbsenceRequestDTO(AbsenceRequest absenceRequest) {
		this(absenceRequest.getId(), absenceRequest.getStartingDate(), absenceRequest.getEndingDate());
	}
	
	public AbsenceRequestDTO(Long id, Date startingDate, Date endingDate) {
		super();
		this.id = id;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
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
	
	
}
