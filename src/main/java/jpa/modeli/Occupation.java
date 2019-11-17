package jpa.modeli;

import java.util.Date;

public class Occupation {
	private Date startingTime;
	private Date endingTime;
	private int durationMinutes;
	
	@SuppressWarnings("deprecation")
	public Occupation(Date pocetak, Date kraj) {
		super();
		this.startingTime = pocetak;
		this.endingTime = kraj;
		this.durationMinutes = kraj.getMinutes() - pocetak.getMinutes();
	}
	
	@SuppressWarnings("deprecation")
	public Occupation(Date pocetak, int duration) {
		super();
		this.startingTime = pocetak;
		this.durationMinutes = duration;
		this.endingTime.setMinutes(pocetak.getMinutes() + durationMinutes);
	}

	public Date getPocetak() {
		return startingTime;
	}
	public void setPocetak(Date pocetak) {
		this.startingTime = pocetak;
	}
	public Date getKraj() {
		return endingTime;
	}
	public void setKraj(Date kraj) {
		this.endingTime = kraj;
	}
	public int getDurationMinutes() {
		return durationMinutes;
	}
	public void setDurationMinutes(int duration) {
		this.durationMinutes = duration;
	}
	
	
	
}
