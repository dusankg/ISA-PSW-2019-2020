package jpa.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.dto.ExaminationDTO;
import jpa.modeli.Doctor;
import jpa.modeli.Examination;
import jpa.modeli.ExaminationType;
import jpa.modeli.Patient;
import jpa.service.DoctorService;
import jpa.service.EmailService;
import jpa.service.ExaminationService;
import jpa.service.ExaminationTypeService;
import jpa.service.PatientService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200", "http://localhost:8080"},allowCredentials= "true")
@RequestMapping(value = "api/examinations")
public class ExaminationController {
	private Logger logger = LoggerFactory.getLogger(ExaminationController.class);
	@Autowired
	private ExaminationService examinationService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private ExaminationTypeService examinationTypeService;
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ExaminationDTO>> getAllExaminations(HttpSession Session){
		List<Examination> examinations = examinationService.findAll();
		
		//convert examinations to DTOs
		List<ExaminationDTO> examinationsDTO = new ArrayList<>();
		for (Examination e : examinations) {
			examinationsDTO.add(new ExaminationDTO(e));
		}
		
		return new ResponseEntity<>(examinationsDTO, HttpStatus.OK);
	}
	@GetMapping(value = "/nonReserved")
	public ResponseEntity<List<ExaminationDTO>> getAllNonReservedExaminations(HttpSession Session){
		if(Session.getAttribute("role").equals("PATIENT")){
		List<Examination> examinations = examinationService.findAll();
		
		//convert examinations to DTOs
		List<ExaminationDTO> examinationsDTO = new ArrayList<>();
		for (Examination e : examinations) {
			if(e.getPatient()==null){
			examinationsDTO.add(new ExaminationDTO(e));
			}
		}
		System.out.println(examinationsDTO.size());
		return new ResponseEntity<>(examinationsDTO, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping(value = "/allByClinic")
	public ResponseEntity<List<ExaminationDTO>> getAllExaminationss(HttpSession Session){
		List<Examination> examinations = examinationService.findAll();
		
		//convert examinations to DTOs
		List<ExaminationDTO> examinationsDTO = new ArrayList<>();
		System.out.println(Session.getAttribute("selectedClinicId"));
		for (Examination e : examinations) {
			if(Session.getAttribute("selectedClinicId")==e.getClinic().getId()){
				if(e.getPatient()==null){
				examinationsDTO.add(new ExaminationDTO(e));
				}
			}
		}
		
		return new ResponseEntity<>(examinationsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExaminationDTO> getExamination(@PathVariable Long id) {

		Examination examination = examinationService.findOne(id);

		// examination must exist
		if (examination == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new ExaminationDTO(examination), HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<ExaminationDTO> saveExamination(@RequestBody ExaminationDTO examinationDTO) {
		
		// a new examination must have examination type defined
		if(examinationDTO.getType() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		ExaminationType examinationType = examinationTypeService.findOne(examinationDTO.getType().getId());
		
		if(examinationType == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Examination examination = new Examination();
		examination.setId(null);
		examination.setDate((Date) examinationDTO.getDate());
		examination.setStartTime(examinationDTO.getStartTime());
		examination.setEndTime(examinationDTO.getEndTime());
		examination.setPrice(examinationDTO.getPrice());
		examination.setAccepted(examinationDTO.getAccepted());
		examination.setOperation(examinationDTO.getOperation());
		examination.setType(examinationType);

		// Maybe not ideal solution check if Examination can exist without doctor
		Doctor doctor;
		if(examinationDTO.getDoctor() != null) {
			doctor = doctorService.findOne(examinationDTO.getDoctor().getId());
			examination.setDoctor(doctor);
		}
		
		examination = examinationService.save(examination);
		return new ResponseEntity<>(new ExaminationDTO(examination), HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/sendVerificationMail/{id1}")
	public ResponseEntity<Void> acceptPatient(@PathVariable Long id1,HttpSession Session){
	
		Patient patient=patientService.findOne((Long)Session.getAttribute("id"));
		Examination examination=examinationService.findOne(id1);
		
		if(patient!=null){
			
			// slanje mejla za validaciju
			try {
				emailService.sendNotificaitionAsyncReserve(patient,examination);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
			
			patient.setAccepted(true);
			patient = patientService.save(patient);
			System.out.println("Stanje sada: "+ patient.isValidated());
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		
	}
	
	
	
	@GetMapping(value = "reserve/{id1}")
	public ResponseEntity<ExaminationDTO> updateExamination(@PathVariable Long id1,HttpSession Session ) {
		System.out.println("ARE YOU HEREEEEE???");
		// an examination must exist
		System.out.println(id1);

		Examination examination = examinationService.findOne(id1);
		Patient patient = patientService.findOne((Long)Session.getAttribute("id"));
		if (examination == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		examination.setPatient(patient);
		examination = examinationService.save(examination);
		System.out.println(examination.getPatient().getName());
		return new ResponseEntity<>(new ExaminationDTO(examination), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteExamination(@PathVariable Long id) {

		Examination examination = examinationService.findOne(id);

		if (examination != null) {
			examinationService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
