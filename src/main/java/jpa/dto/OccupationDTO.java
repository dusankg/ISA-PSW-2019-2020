package jpa.dto;

import java.sql.Date;

import jpa.modeli.Occupation;

public class OccupationDTO {

	private Long id;
	private Date date;
	Boolean h7;
	Boolean h8;
	Boolean h9;
	Boolean h10;
	Boolean h11;
	Boolean h12;
	Boolean h13;
	Boolean h14;
	Boolean h15;
	Boolean h16;
	Boolean h17;
	
	public OccupationDTO() {
		super();
	}

	public OccupationDTO(Occupation oc) {
		super();
		h7 = oc.getH7();
		h8 = oc.getH8();
		h9 = oc.getH9();
		h10 = oc.getH10();
		h11 = oc.getH11();
		h12 = oc.getH12();
		h13 = oc.getH13();
		h14 = oc.getH14();
		h15 = oc.getH15();
		h16 = oc.getH16();
		h17 = oc.getH17();
		date = (Date) oc.getDate();
		
	}

	
	public Date getDate() {
		return date;
	}


	public void setDate(Date startingDate) {
		this.date = startingDate;
	}

	public OccupationDTO(Date date, Boolean h7, Boolean h8, Boolean h9, Boolean h10, Boolean h11, Boolean h12,
			Boolean h13, Boolean h14, Boolean h15, Boolean h16, Boolean h17) {
		super();
		this.date = date;
		this.h7 = h7;
		this.h8 = h8;
		this.h9 = h9;
		this.h10 = h10;
		this.h11 = h11;
		this.h12 = h12;
		this.h13 = h13;
		this.h14 = h14;
		this.h15 = h15;
		this.h16 = h16;
		this.h17 = h17;
	}
	
	public OccupationDTO(Long id, Date date, Boolean h7, Boolean h8, Boolean h9, Boolean h10, Boolean h11, Boolean h12,
			Boolean h13, Boolean h14, Boolean h15, Boolean h16, Boolean h17) {
		super();
		this.id = id;
		this.date = date;
		this.h7 = h7;
		this.h8 = h8;
		this.h9 = h9;
		this.h10 = h10;
		this.h11 = h11;
		this.h12 = h12;
		this.h13 = h13;
		this.h14 = h14;
		this.h15 = h15;
		this.h16 = h16;
		this.h17 = h17;
	}

	public Boolean getH7() {
		return h7;
	}

	public void setH7(Boolean h7) {
		this.h7 = h7;
	}

	public Boolean getH8() {
		return h8;
	}

	public void setH8(Boolean h8) {
		this.h8 = h8;
	}

	public Boolean getH9() {
		return h9;
	}

	public void setH9(Boolean h9) {
		this.h9 = h9;
	}

	public Boolean getH10() {
		return h10;
	}

	public void setH10(Boolean h10) {
		this.h10 = h10;
	}

	public Boolean getH11() {
		return h11;
	}

	public void setH11(Boolean h11) {
		this.h11 = h11;
	}

	public Boolean getH12() {
		return h12;
	}

	public void setH12(Boolean h12) {
		this.h12 = h12;
	}

	public Boolean getH13() {
		return h13;
	}

	public void setH13(Boolean h13) {
		this.h13 = h13;
	}

	public Boolean getH14() {
		return h14;
	}

	public void setH14(Boolean h14) {
		this.h14 = h14;
	}

	public Boolean getH15() {
		return h15;
	}

	public void setH15(Boolean h15) {
		this.h15 = h15;
	}

	public Boolean getH16() {
		return h16;
	}

	public void setH16(Boolean h16) {
		this.h16 = h16;
	}

	public Boolean getH17() {
		return h17;
	}

	public void setH17(Boolean h17) {
		this.h17 = h17;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
