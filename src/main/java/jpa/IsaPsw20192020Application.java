package jpa;


import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class IsaPsw20192020Application {

	public static void main(String[] args) {
		SpringApplication.run(IsaPsw20192020Application.class, args);
		
		// treba mi da bih mogao da pozivam funkciju automatskog bukiranja doktora i soba
		//DoctorController doctorController = new DoctorController();
		//doctorController.bookDoctorAndMedicalRoomByTime();
		
		
		
	}	
	

}
