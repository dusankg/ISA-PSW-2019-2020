package jpa.dto;

import java.sql.Date;

public class OccupationDTO {


	private Date startingDate;
	private int durationMinutes;
	
	
	public OccupationDTO() {
		super();
	}


	public OccupationDTO(Date startingDate, int durationMinutes) {
		super();
		this.startingDate = startingDate;
		this.durationMinutes = durationMinutes;
	}


	public Date getStartingDate() {
		return startingDate;
	}


	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}


	public int getDurationMinutes() {
		return durationMinutes;
	}


	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}
	
	
}
