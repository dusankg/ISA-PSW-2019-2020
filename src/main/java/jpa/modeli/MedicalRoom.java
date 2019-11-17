package jpa.modeli;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MedicalRoom {
	public long id;
	
	//
	private Boolean operational; //True ako je operaciona, false ako je obicna
	private int number;
	private Date date; 
	//Pocetni trenutci pregleda. Duration cemo dodavati iz objekta klase examination
	private Set<Occupation>occupations=new HashSet<Occupation>();
	
}
