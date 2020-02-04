package jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.dto.AbsenceRequestDTO;
import jpa.dto.DoctorDTO;
import jpa.modeli.AbsenceRequest;
import jpa.modeli.Clinic;
import jpa.modeli.Doctor;
import jpa.service.ClinicService;
import jpa.service.DoctorService;
import jpa.service.EmailService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RequestMapping(value = "api/doctors")
public class DoctorController {

	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private EmailService emailService;
	
	private Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<DoctorDTO>> getAllDoctors(){
		List<Doctor> doctors = doctorService.findAll();
		
		//convert doctors to DTOs
		List<DoctorDTO> doctorsDTO = new ArrayList<>();
		for (Doctor d : doctors) {
			doctorsDTO.add(new DoctorDTO(d));
		}
		
		return new ResponseEntity<>(doctorsDTO, HttpStatus.OK);
	}
	
	//Pageable check
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DoctorDTO> getDoctor(@PathVariable Long id) {

		Doctor doctor = doctorService.findOne(id);

		// doctor must exist
		if (doctor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<DoctorDTO> saveDoctor(@RequestBody DoctorDTO doctorDTO) {

		if(doctorDTO.getClass() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Clinic clinic = clinicService.findOne(doctorDTO.getClinic().getId());
		
		if(clinic == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Doctor doctor = new Doctor();
		doctor.setId(222L);
		doctor.setName(doctorDTO.getName());
		doctor.setSurname(doctorDTO.getSurname());
		doctor.setEmail(doctorDTO.getEmail());
		doctor.setPassword(doctorDTO.getPassword());
		doctor.setAdress(doctorDTO.getAdress());
		doctor.setCity(doctorDTO.getCity());
		doctor.setState(doctorDTO.getState());
		doctor.setPhone(doctorDTO.getPhone());
		doctor.setWorkHourStart(doctorDTO.getWorkHourStart());
		doctor.setWorkHourFinish(doctorDTO.getWorkHourFinish());
		doctor.setClinic(clinic);
		
		doctor = doctorService.save(doctor);
		return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<DoctorDTO> updateDoctor(@RequestBody DoctorDTO doctorDTO) {

		// a doctor must exist
		Doctor doctor = doctorService.findOne(doctorDTO.getId());

		if (doctor == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		doctor.setName(doctorDTO.getName());
		doctor.setSurname(doctorDTO.getSurname());
		doctor.setEmail(doctorDTO.getEmail());
		doctor.setPassword(doctorDTO.getPassword());
		doctor.setAdress(doctorDTO.getAdress());
		doctor.setCity(doctorDTO.getCity());
		doctor.setState(doctorDTO.getState());
		doctor.setPhone(doctorDTO.getPhone());
		doctor.setWorkHourStart(doctorDTO.getWorkHourStart());
		doctor.setWorkHourFinish(doctorDTO.getWorkHourFinish());

		doctor = doctorService.save(doctor);
		return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {

		Doctor doctor = doctorService.findOne(id);

		if (doctor != null) {
			doctorService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/{doctorId}/absencerequest")	
	public ResponseEntity<AbsenceRequestDTO> getDoctorsAbsenceRequest(@PathVariable Long doctorId){
		
		Doctor doctor = doctorService.findOne(doctorId);
		
		AbsenceRequest absenceRequest = doctor.getAbsenceRequest();
		AbsenceRequestDTO absenceRequestDTO = new AbsenceRequestDTO(absenceRequest);
		
		return new ResponseEntity<>(absenceRequestDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/accept/{id}")
	public ResponseEntity<Void> acceptRequest(@PathVariable Long id){
		Doctor doctor = doctorService.findOne(id);
		
		if(doctor != null) {
			try {
				emailService.sendNotificationAccept(doctor);
			} catch(Exception e) {
				logger.info("Error while sending email!");
			}
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/decline/{id}/{message}")
	public ResponseEntity<Void> declineRequest(@PathVariable Long id, @PathVariable String message){
		Doctor doctor = doctorService.findOne(id);
		
		if(doctor != null) {
			try {
				emailService.sendNotificationDecline(doctor, message);
			} catch(Exception e) {
				logger.info("Error while sending email!");
			}
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
