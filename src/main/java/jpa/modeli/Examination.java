package jpa.modeli;
import java.util.Date;

public class Examination {

	private long id;
	
	private Date date;
	private ExaminationType type; //Pitaj asistenta da li moze ovako, zbog baze. Odavde vuce cenu
	private int duration;
	private MedicalRoom room;
	
	
	
}
