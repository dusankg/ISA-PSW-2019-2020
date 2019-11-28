package jpa.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<ClinicalCenterAdministratorDTO> saveClinic(@RequestBody ClinicalCenterAdministratorDTO clinicDTO) {

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

		
		System.out.println("********* Prosledjeno ime administrator: " + clinicDTO.getName()+ " ***************");

		try {
			emailService.sendNotificaitionAsync(Patient);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
		clinic = service.save(clinic);
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
