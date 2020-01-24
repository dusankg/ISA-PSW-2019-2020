package jpa.dto;

import java.util.Date;

import jpa.modeli.MedicalRoom;

public class MedicalRoomDTO {

	private Long id;
	private Boolean operational;
	private Boolean reserved;
	private String roomCodeName;
	private Integer roomNumber;
	private Date date; 
	
	public MedicalRoomDTO() {}
	
	public MedicalRoomDTO(MedicalRoom medicalRoom){
		this(medicalRoom.getId(), medicalRoom.getOperational(), medicalRoom.getReserved(), medicalRoom.getRoomCodeName(), medicalRoom.getRoomNumber(), medicalRoom.getDate());
	}
	
	public MedicalRoomDTO(Long id, Boolean operational, Boolean reserved, String roomCodeName, Integer roomNumber, Date date) {
		super();
		this.id = id;
		this.operational = operational;
		this.reserved = reserved;
		this.roomCodeName = roomCodeName;
		this.roomNumber = roomNumber;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getOperational() {
		return operational;
	}

	public void setOperational(Boolean operational) {
		this.operational = operational;
	}

	public Boolean getReserved() {
		return reserved;
	}

	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}

	public String getRoomCodeName() {
		return roomCodeName;
	}

	public void setRoomCodeName(String roomCodeName) {
		this.roomCodeName = roomCodeName;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
