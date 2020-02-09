package jpa.constants;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ExaminationConstants {
	public static final Calendar dateCalendar;
	
	static {
		dateCalendar = GregorianCalendar.getInstance();
		dateCalendar.clear();
		dateCalendar.set(2020, 1, 1);
	}
	
	public static final Long DB_ID = 1L;
	public static final Integer DB_PRICE = 1500;
	public static final Long DB_TYPE_ID = 1L;
	public static final Long DB_CLINIC_ID = 1L;
	public static final Long DB_DOCTOR_ID = 1L;
	public static final Integer DB_START_TIME = 420;
	public static final Integer DB_END_TIME = 480;
	public static final Boolean DB_OPERATION = true;
	public static final Boolean DB_ACCEPTED = true;
	public static final Long DB_PATIENT_ID = 1L;
	
	public static final Calendar dateCalendarNew;
	static {
		dateCalendarNew = GregorianCalendar.getInstance();
		dateCalendarNew.clear();
		dateCalendarNew.set(2020, 1, 1);
	}
	
	public static final Integer NEW_START_TIME = 520;
	public static final Integer NEW_END_TIME = 580;
	
    public static final int DB_COUNT = 2;
}
