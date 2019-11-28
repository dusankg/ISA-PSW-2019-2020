package jpa.modeli;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicalRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "operational")
	private Boolean operational; //True if it is operational room, false if it is ordinary
	@Column(name = "reserved")
	private Boolean reserved;
	@Column(name = "roomCodename", nullable = false)
	private String roomCodeName;
	@Column(name = "date")
	private Date date; 
	//Pocetni trenuci pregleda. Duration cemo dodavati iz objekta klase examination
	//private Set<Occupation>occupations=new HashSet<Occupation>();
	
	public MedicalRoom() {}
	
	public MedicalRoom(Boolean operational, Boolean reserved, String roomCodename, Date date) {
		super();
		this.operational = operational;
		this.reserved = reserved;
		this.roomCodeName = roomCodename;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public void setRoomCodeName(String roomCodename) {
		this.roomCodeName = roomCodename;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	/*
	 * Need to add mapping for Examination when it is created*/
	
	
	
}
