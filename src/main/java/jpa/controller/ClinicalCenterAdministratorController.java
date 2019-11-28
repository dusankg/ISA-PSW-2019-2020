package jpa.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import jpa.modeli.Clinic;
import jpa.modeli.ClinicalCenterAdministrator;
import jpa.service.ClinicalCenterAdministratorService;
import jpa.service.EmailService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
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

		ClinicalCenterAdministrator clinic = service.findOne(id);

		// studen must exist
		if (clinic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ClinicalCenterAdministratorDTO>(new ClinicalCenterAdministratorDTO(clinic), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ClinicalCenterAdministratorDTO> saveAdministrator(@RequestBody ClinicalCenterAdministratorDTO clinicDTO) {

		ClinicalCenterAdministrator clinic = new ClinicalCenterAdministrator();
		clinic.setId(222);
		clinic.setName(clinicDTO.getName());
		clinic.setSurname(clinicDTO.getSurname());
		clinic.setEmail(clinicDTO.getEmail());
		clinic.setPassword(clinicDTO.getPassword());
		clinic.setAdress(clinicDTO.getAdress());
		clinic.setCity(clinicDTO.getCity());
		clinic.setState(clinicDTO.getState());
		clinic.setPhone(clinicDTO.getPhone());

		
		System.out.println("********* Prosledjeno ime administratora: " + clinicDTO.getName()+ " ***************");


		
		clinic = service.save(clinic);
		
		List<ClinicalCenterAdministrator> administratoriIzBaze = service.findAll();
		long id = 0;
		for(ClinicalCenterAdministrator adm : administratoriIzBaze) {
			if(adm.getEmail().equals(clinicDTO.getEmail())) {
				id = adm.getId();
				System.out.println("Id novog administratora je: "+id);
			}
		}
		try {
			emailService.sendNotificaitionAsync(clinic);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		return new ResponseEntity<>(new ClinicalCenterAdministratorDTO(clinic), HttpStatus.CREATED);
	}
	
	
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<ClinicalCenterAdministratorDTO> updateAdministrator(@RequestBody ClinicalCenterAdministratorDTO clinicDTO) {

		// a clinic must exist
		ClinicalCenterAdministrator clinic = service.findOne(clinicDTO.getId());

		if (clinic == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		clinic.setName(clinicDTO.getName());
		clinic.setSurname(clinicDTO.getSurname());
		clinic.setEmail(clinicDTO.getEmail());
		clinic.setPassword(clinicDTO.getPassword());
		clinic.setAdress(clinicDTO.getAdress());
		clinic.setCity(clinicDTO.getCity());
		clinic.setState(clinicDTO.getState());
		clinic.setPhone(clinicDTO.getPhone());
		
		clinic = service.save(clinic);
		return new ResponseEntity<>(new ClinicalCenterAdministratorDTO(clinic), HttpStatus.OK);
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

		ClinicalCenterAdministrator clinic = service.findOne(id);

		if (clinic != null) {
			service.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
}
