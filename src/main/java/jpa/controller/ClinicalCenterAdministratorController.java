package jpa.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import jpa.dto.ClinicDTO;
import jpa.dto.ClinicalCenterAdministratorDTO;
import jpa.dto.DoctorDTO;
import jpa.modeli.Clinic;
import jpa.modeli.ClinicalCenterAdministrator;
import jpa.modeli.Doctor;
import jpa.service.ClinicalCenterAdministratorService;
import jpa.service.EmailService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" },allowCredentials= "true")
@RequestMapping(value = "api/clinicalCenterAdministrators")
public class ClinicalCenterAdministratorController {
	private Logger logger = LoggerFactory.getLogger(PatientController.class);
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ClinicalCenterAdministratorService service;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ClinicalCenterAdministratorDTO>> getAllAdministrators() {

		List<ClinicalCenterAdministrator> clinics = service.findAll();

		// convert clinics to DTOs
		List<ClinicalCenterAdministratorDTO> clinicDTO = new ArrayList<>();
		for (ClinicalCenterAdministrator c : clinics) {
			clinicDTO.add(new ClinicalCenterAdministratorDTO(c));
		}

		return new ResponseEntity<>(clinicDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/login/{id}")
	public ResponseEntity<ClinicalCenterAdministratorDTO> loginDoctor(@PathVariable Long id, HttpSession Session){

		ClinicalCenterAdministrator admin = service.findOne(id);
		if(admin == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Session.setAttribute("role", "CLINICALCENTERADMINISTRATOR");
		Session.setAttribute("id", id);
		
		return new ResponseEntity<>(new ClinicalCenterAdministratorDTO(admin),HttpStatus.OK);
	}
	
	// Da li ovo mora da se pise?
	@GetMapping
	public ResponseEntity<List<ClinicalCenterAdministratorDTO>> getAdministratorsPage(Pageable page) {

		Page<ClinicalCenterAdministrator> clinics = service.findAll(page);


		List<ClinicalCenterAdministratorDTO> clinicsDTO = new ArrayList<>();
		for (ClinicalCenterAdministrator s : clinics) {
			clinicsDTO.add(new ClinicalCenterAdministratorDTO(s));
		}

		return new ResponseEntity<>(clinicsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClinicalCenterAdministratorDTO> getAdministrators(@PathVariable Long id) {

		System.out.println("Indeks trazenog administratora je: " + id);
		ClinicalCenterAdministrator admin = service.findOne(id);
		
		if (admin == null) {
			System.out.println("Nisam nasao sa idejem" + id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ClinicalCenterAdministratorDTO>(new ClinicalCenterAdministratorDTO(admin), HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/changePassword/{id}/{newPassword}")
	public ResponseEntity<ClinicalCenterAdministratorDTO> changePasswordClinicalCenterAdministrator(@PathVariable Long id, @PathVariable String newPassword) {


		ClinicalCenterAdministrator admin = service.findOne(id);
		
		if (admin == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		admin.setPassword(newPassword);
		admin = service.save(admin);
		return new ResponseEntity<ClinicalCenterAdministratorDTO>(new ClinicalCenterAdministratorDTO(admin), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ClinicalCenterAdministratorDTO> saveAdministrator(@RequestBody ClinicalCenterAdministratorDTO clinicDTO) {

		ClinicalCenterAdministrator admin = new ClinicalCenterAdministrator();
		admin.setId(222);
		admin.setName(clinicDTO.getName());
		admin.setSurname(clinicDTO.getSurname());
		admin.setEmail(clinicDTO.getEmail());
		admin.setPassword(clinicDTO.getPassword());
		admin.setAdress(clinicDTO.getAdress());
		admin.setCity(clinicDTO.getCity());
		admin.setState(clinicDTO.getState());
		admin.setPhone(clinicDTO.getPhone());

		
		System.out.println("********* Prosledjeno ime administratora: " + clinicDTO.getName()+ " ***************");


		
		admin = service.save(admin);
		
		List<ClinicalCenterAdministrator> administratoriIzBaze = service.findAll();
		long id = 0;
		for(ClinicalCenterAdministrator adm : administratoriIzBaze) {
			if(adm.getEmail().equals(clinicDTO.getEmail())) {
				id = adm.getId();
				System.out.println("Id novog administratora je: "+id);
			}
		}
		try {
			emailService.sendNotificaitionAsync(admin);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		return new ResponseEntity<>(new ClinicalCenterAdministratorDTO(admin), HttpStatus.CREATED);
	}
	
	
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<ClinicalCenterAdministratorDTO> updateAdministrator(@RequestBody ClinicalCenterAdministratorDTO clinicDTO) {

		// a admin must exist
		ClinicalCenterAdministrator admin = service.findOne(clinicDTO.getId());

		if (admin == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		admin.setName(clinicDTO.getName());
		admin.setSurname(clinicDTO.getSurname());
		admin.setEmail(clinicDTO.getEmail());
		admin.setPassword(clinicDTO.getPassword());
		admin.setAdress(clinicDTO.getAdress());
		admin.setCity(clinicDTO.getCity());
		admin.setState(clinicDTO.getState());
		admin.setPhone(clinicDTO.getPhone());
		
		admin = service.save(admin);
		return new ResponseEntity<>(new ClinicalCenterAdministratorDTO(admin), HttpStatus.OK);
	}
	
	/*
	 * validation is automated, administrator needs just to click on link and profile is validated
	 * */
	@GetMapping(value = "/validate/{id}")
	public ResponseEntity<Void> validateAdministrator(@PathVariable Long id) {

		ClinicalCenterAdministrator admin = service.findOne(id);
		
		if (admin != null) {
			admin.setValidated(true);
			admin = service.save(admin);
			System.out.println("Admin sa id-jem: "+id+" je valiran");
			System.out.println("Njegovo stanje je sada: "+admin.isValidated());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("Prosledjeno je, ali je admin null");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {

		ClinicalCenterAdministrator admin = service.findOne(id);

		if (admin != null) {
			service.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
}
