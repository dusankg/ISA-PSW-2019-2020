package jpa.modeli;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AbsenceRequest {
	
	@Id
	private long id;
	private Date startingDate;
	private Date endingDate;
	
	
}
